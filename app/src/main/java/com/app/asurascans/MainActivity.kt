package com.app.asurascans

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.app.asurascans.core.BaseActivity
import com.app.asurascans.core.BaseViewModel
import com.app.asurascans.helper.tittleBoard
import com.app.asurascans.ui.navigation.NavigationItem
import com.app.asurascans.ui.screen.AlphabetScreen
import com.app.asurascans.ui.screen.DiscoverScreen
import com.app.asurascans.ui.screen.HistoryBookmark
import com.app.asurascans.ui.screen.home.HomeScreen
import com.app.asurascans.ui.screen.SearchActivity
import com.app.asurascans.ui.screen.ProfileActivity
import com.app.asurascans.ui.screen.SettingScreen
import com.app.asurascans.ui.screen.detail.DetailVM
import com.app.asurascans.ui.screen.home.HomeVM
import com.app.asurascans.ui.theme.AsuraScansTheme
import com.app.asurascans.ui.theme.BackroundColor
import com.app.asurascans.ui.theme.ColorBlack
import com.app.asurascans.ui.theme.ColorButtonRefreshReadChapter
import com.app.asurascans.ui.theme.primaryColor

class MainActivity : BaseActivity() {


    private val items = listOf(
        NavigationItem.Home,
        NavigationItem.List,
        NavigationItem.Discover,
        NavigationItem.History,
        NavigationItem.Setting
    )


    override fun viewModel(): HomeVM {
        val viewModel: HomeVM by viewModels()
        return viewModel
    }

    @Composable
    override fun OnInitViewCompose()  {
        LaunchedEffect(true) {
            viewModel().showFab(true)
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun BaseContent(
        paddingValues: PaddingValues,
    ) {

        val currentRoute = getBaseCurrentRouteNavigation()
        requestPermissions(Manifest.permission.POST_NOTIFICATIONS)
        return Column(
            Modifier
                .padding(paddingValues)
                .background(BackroundColor)
        ) {
            //    Header()
            NavHost(
                navController = getBaseRememberNavController(),
                startDestination = NavigationItem.Home.route
            ) {


                composable(NavigationItem.Home.route) {
                    HomeScreen(modifier = Modifier.weight(1f), viewModel())
                }
                composable(NavigationItem.List.route) {
                    AlphabetScreen(modifier = Modifier.weight(1f))
                }
                composable(NavigationItem.Discover.route) {
                    DiscoverScreen()
                }
                composable(NavigationItem.History.route) {
                    HistoryBookmark()
                }

                composable(NavigationItem.Setting.route) {
                    SettingScreen()
                }
            }
            /* AlphabetScreen(modifier = Modifier.weight(1f))
                        HomeScreen(modifier = Modifier.weight(1f))*/
        }
    }

    @Composable
    override fun BaseTopBar() {
        val context = LocalContext.current
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .background(BackroundColor)
                        .padding(vertical = 5.dp, horizontal = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                    ) {
                        AsyncImage(
                            model = R.drawable.ic_small_app, contentDescription = null,
                            modifier = Modifier.size(50.dp)
                        )
                        //  Icon(painter = painterResource(id = R.drawable.ic_small_app), contentDescription =null )
                    }

                    Row(
                        modifier = Modifier.wrapContentSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                context.startActivity(Intent(context, SearchActivity::class.java))
                            },
                            modifier = Modifier.size(25.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = null
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.size(25.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_notif),
                                contentDescription = null
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        AsyncImage(
                            model = R.drawable.ic_person, contentDescription = null,
                            modifier = Modifier
                                .size(35.dp)
                                .clickable {
                                    context.startActivity(
                                        Intent(
                                            context,
                                            ProfileActivity::class.java
                                        )
                                    )
                                }
                        )
                    }

                }

                val name = items.find { it.route == getBaseCurrentRouteNavigation() }?.title

                tittleBoard(
                    name ?: "",
                    Modifier
                        .wrapContentSize()
                        .align(Alignment.Center)
                )
            }
            Divider()
        }
    }

    @Composable
    override fun BaseBottomBar() {
        val currentRoute = getBaseCurrentRouteNavigation()
        val navController = getBaseRememberNavController()
        BottomAppBar {

            items.forEach { item ->
                Log.d("NavigationItem", "Route: ${item.route}, Title: ${item.title}")
                Log.d("CurrentRoute", "Current Route: $currentRoute")

                NavigationBarItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            modifier = Modifier.size(25.dp),
                            contentDescription = item.title
                        )
                    },
                    label = { Text(text = item.title) },
                    alwaysShowLabel = false,
                    selected = currentRoute == item.route,
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = ColorButtonRefreshReadChapter,
                        unselectedTextColor = ColorButtonRefreshReadChapter,
                        selectedTextColor = primaryColor,
                        selectedIconColor = primaryColor
                    ),
                    onClick = {
                        val showFloatActionButton = items.first().route == item.route
                        viewModel().showFab(showFloatActionButton)
                        Log.d("NavigationClick", "Navigating to: ${item.route}")
                        navController.navigate(item.route)
                    }
                )
            }
        }

    }


    @Composable
    override fun BaseFloatingActionButton() {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .size(60.dp),
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = ColorBlack,
                containerColor = primaryColor
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_refresh),
                contentDescription = null,
                tint = ColorBlack,
                modifier = Modifier.size(40.dp)
            )
        }


    }
}


@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AsuraScansTheme {
        Greeting("Android")
    }
}