package com.app.asurascans.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.app.asurascans.ui.screen.HomeScreen
import com.app.asurascans.ui.theme.AsuraScansTheme
import com.app.asurascans.ui.theme.BackroundColor
import com.app.asurascans.ui.theme.ColorNav

abstract class BaseActivity : ComponentActivity() {

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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BackroundColor)
                        .imePadding()
                        .fillMaxSize()
                        .systemBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BaseContent()
                }
            }
        }
    }

    @Composable
    private fun BaseContent() {
        // Common UI elements (e.g., snackbars, loaders) can be added here
        ScreenContent()
    }

    @Composable
    abstract fun ScreenContent()
}