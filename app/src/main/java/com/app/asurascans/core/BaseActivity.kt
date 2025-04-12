package com.app.asurascans.core

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.asurascans.ui.bottomsheet.Comments
import com.app.asurascans.ui.theme.AsuraScansTheme
import com.app.asurascans.ui.theme.BackroundColor
import com.app.asurascans.ui.theme.ColorNav
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberUpdatedState

@AndroidEntryPoint
abstract class BaseActivity : ComponentActivity() {

    protected open fun viewModel(): BaseViewModel? = null

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val grantedPermissions = permissions.filterValues { it }.keys
        val deniedPermissions = permissions.filterValues { !it }.keys

        if (grantedPermissions.isNotEmpty()) {
            onPermissionsGranted(grantedPermissions)
        }
        if (deniedPermissions.isNotEmpty()) {
            onPermissionsDenied(deniedPermissions)
        }
    }

    /** 🔹 Request multiple permissions */
    fun requestPermissions(vararg permissions: String) {
        permissionLauncher.launch(permissions as Array<String>)
    }

    /** 🔹 Check if all permissions are granted */
    fun hasPermissions(vararg permissions: String): Boolean {
        return permissions.all {
            ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
        }
    }

    /** 🔹 Override in child activity to handle granted permissions */
    open fun onPermissionsGranted(grantedPermissions: Set<String>) {}

    /** 🔹 Override in child activity to handle denied permissions */
    open fun onPermissionsDenied(deniedPermissions: Set<String>) {}


    private lateinit var navController: NavHostController

    @Composable
    fun getBaseRememberNavController(): NavHostController {
        if (!this::navController.isInitialized) {
            navController = rememberNavController()
        }
        return navController
    }

    @Composable
    fun getBaseNavBackStackEntry() =
        getBaseRememberNavController().currentBackStackEntryAsState().value

    @Composable
    fun getBaseCurrentRouteNavigation() = getBaseNavBackStackEntry()?.destination?.route

    @Composable
    protected open fun OnInitViewCompose(): Unit? = null

    @Composable
    protected open fun BaseContent(
        paddingValues: PaddingValues,
    ): Unit? = null

    @Composable
    protected open fun BaseTopBar(): Unit? = null

    @Composable
    protected open fun BaseBottomBar(): Unit? = null

    @Composable
    protected open fun BaseFloatingActionButton(): Unit? = null

    @Composable
    protected open fun BaseBottomsheet(): Unit? = null

    @SuppressLint("CoroutineCreationDuringComposition", "UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                scrim = BackroundColor.toArgb(),
            ),
            navigationBarStyle = SystemBarStyle.light(
                scrim = ColorNav.toArgb(),
                darkScrim = ColorNav.toArgb()
            )
        )

        setContent {


            AsuraScansTheme {
                BaseScaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BackroundColor)
                        .imePadding()
                        .fillMaxSize()
                        .systemBarsPadding(),
                    viewModel()
                )
                // A surface container using the 'background' color from the theme

            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
    @Composable
    fun BaseScaffold(modifier: Modifier, vm: BaseViewModel?) {
        val bottomSheetState = vm?.bottomSheetState
        val showFab = vm?.showFab
        getSnackbar(vm, Modifier)

        Surface(
            modifier = modifier,
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = {
                    BaseTopBar()
                },
                bottomBar = {
                    BaseBottomBar()
                },
                content = {
                    BaseContent(it)
                    if (bottomSheetState?.value == true) {
                        Comments {
                            vm.setBottomSheetSate(it)
                        }
                    }

                },
                floatingActionButton = {
                    if (showFab?.value==true) {
                        BaseFloatingActionButton()
                    }
                }
            )

        }

        getSnackbar(vm = vm, Modifier)
        OnInitViewCompose()
    }

    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    private fun getSnackbar(vm: BaseViewModel?, modifier: Modifier): SnackbarHostState {
        val snackbarHostState = remember { SnackbarHostState() }
        val snackbarMessageState by vm?.snackbarMessage?.collectAsStateWithLifecycle()
            ?: remember { mutableStateOf(UIState.OnIdle) }

        val snackBarContentColor = rememberUpdatedState(
            when (snackbarMessageState) {
                is UIState.OnError -> Color.Red
                is UIState.OnSuccess<*> -> Color.Green
                else -> SnackbarDefaults.contentColor
            }
        )

        Box(modifier = modifier.zIndex(1f)) {
            SnackbarHost(
                hostState = snackbarHostState,
                snackbar = { snackData ->
                    Snackbar(
                        snackData,
                        modifier = Modifier
                            .padding(top = 50.dp)
                            .align(Alignment.TopStart),
                        containerColor = snackBarContentColor.value,
                        contentColor = Color.White
                    )
                }
            )
        }

        LaunchedEffect(snackbarMessageState) {
            when (snackbarMessageState) {
                is UIState.OnError -> {
                    snackbarHostState.showSnackbar(
                        message = (snackbarMessageState as UIState.OnError).message ?: ""
                    )
                }

                is UIState.OnSuccess<*> -> {
                    snackbarHostState.showSnackbar(
                        message = (snackbarMessageState as UIState.OnSuccess<*>).data.toString()
                    )
                }

                else -> Unit
            }
        }

        return snackbarHostState
    }

}
