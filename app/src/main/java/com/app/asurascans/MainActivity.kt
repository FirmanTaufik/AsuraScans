package com.app.asurascans

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.app.asurascans.core.BaseActivity
import com.app.asurascans.helper.tittleBoard
import com.app.asurascans.ui.navigation.NavigationItem
import com.app.asurascans.ui.screen.AlphabetScreen
import com.app.asurascans.ui.screen.DiscoverScreen
import com.app.asurascans.ui.screen.HistoryBookmark
import com.app.asurascans.ui.screen.HomeScreen
import com.app.asurascans.ui.screen.SearchActivity
import com.app.asurascans.ui.screen.SettingScreen
import com.app.asurascans.ui.theme.AsuraScansTheme
import com.app.asurascans.ui.theme.BackroundColor
import com.app.asurascans.ui.theme.ColorBlack
import com.app.asurascans.ui.theme.ColorButtonRefreshReadChapter
import com.app.asurascans.ui.theme.primaryColor

class MainActivity : BaseActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun ScreenContent() {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val items = listOf(
            NavigationItem.Home,
            NavigationItem.List,
            NavigationItem.Discover,
            NavigationItem.History,
            NavigationItem.Setting
        )

        Scaffold(
            topBar = {
                Header(currentRoute,items)
            },
            bottomBar = {
                BottomNavigationBar(
                    navController = navController,
                    currentRoute,items
                )
            },
            content = {
                SetupNavGraph(navHostController = navController, Modifier.padding(it))
            },
            floatingActionButton = {
                AnimatedVisibility(visible = currentRoute== items.first().route) {
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
            })


    }

    @Composable
    private fun SetupNavGraph(navHostController: NavHostController, modif: Modifier) {
        Column(modif.background(BackroundColor)) {
        //    Header()
            NavHost(
                navController = navHostController,
                startDestination = NavigationItem.Home.route
            ) {
                composable(NavigationItem.Home.route) {
                    HomeScreen(modifier = Modifier.weight(1f))
                }
                composable(NavigationItem.List .route) {
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
}


@Composable
private fun Header(currentRoute: String?, items: List<NavigationItem>) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .background(BackroundColor)
            .padding(vertical = 10.dp, horizontal = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
        ) {
            AsyncImage(model = R.drawable.ic_small_app, contentDescription = null)
            //  Icon(painter = painterResource(id = R.drawable.ic_small_app), contentDescription =null )
        }

        val name  =  items.find { it.route == currentRoute }?.title

        tittleBoard(name ?: "", Modifier.weight(1f))

       /* Text(text = name ?: "", color = Color.White,
            modifier = Modifier
                .weight(1f),
            textAlign = TextAlign.Center,
            fontSize = 23.sp, fontWeight = FontWeight.Bold)*/

        Row(
            modifier = Modifier.wrapContentSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                context.startActivity(Intent(context, SearchActivity::class.java))
            },
                modifier = Modifier.size(25.dp)) {
                Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null)
            }
            Spacer(modifier = Modifier.width(5.dp))
            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier.size(25.dp)) {
                Icon(painter = painterResource(id = R.drawable.ic_notif), contentDescription = null)
            }
            Spacer(modifier = Modifier.width(5.dp))
            AsyncImage(
                model = R.drawable.ic_person, contentDescription = null,
                modifier = Modifier.size(35.dp)
            )
        }

    }
}

@Composable
fun BottomNavigationBar(
    navController: NavController,
    currentRoute: String?,
    items: List<NavigationItem>
) {

    BottomAppBar {

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = item.icon), modifier = Modifier.size(25.dp), contentDescription = item.title) },
                label = { Text(text = item.title) },
                alwaysShowLabel = false,
                selected = currentRoute == item.route,

                colors = NavigationBarItemDefaults.colors(unselectedIconColor = ColorButtonRefreshReadChapter,
                    unselectedTextColor = ColorButtonRefreshReadChapter, selectedTextColor = primaryColor, selectedIconColor = primaryColor),
                onClick = {
                    navController.navigate(item.route)
                    /* Add code later */
                }
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