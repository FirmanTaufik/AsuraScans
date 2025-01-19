package com.app.asurascans

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.asurascans.core.BaseActivity
import com.app.asurascans.ui.screen.AlphabetScreen
import com.app.asurascans.ui.screen.HomeScreen
import com.app.asurascans.ui.theme.AsuraScansTheme
import com.app.asurascans.ui.theme.BackroundColor
import com.app.asurascans.ui.theme.ColorNav

class MainActivity : BaseActivity() {

    @Composable
    override fun ScreenContent() {
        Column(Modifier.background(BackroundColor)) {
            Header()
            //AlphabetScreen(modifier = Modifier.weight(1f))
            HomeScreen(modifier = Modifier.weight(1f))
        }

    }
}


@Composable
fun Header() {
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            AsyncImage(model = R.drawable.ic_small_app, contentDescription = null)
            //  Icon(painter = painterResource(id = R.drawable.ic_small_app), contentDescription =null )
        }
        Row(modifier = Modifier.wrapContentSize(),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null)
            Spacer(modifier = Modifier.width(5.dp))
            Icon(painter = painterResource(id = R.drawable.ic_notif), contentDescription = null)
            Spacer(modifier = Modifier.width(5.dp))
            AsyncImage(
                model = R.drawable.ic_person, contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }

    }
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