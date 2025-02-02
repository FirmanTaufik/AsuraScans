package com.app.asurascans.ui.navigation

import com.app.asurascans.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    data object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    data object List : NavigationItem("az", R.drawable.ic_list, "AZ-List")
    data object History : NavigationItem("history", R.drawable.ic_history, "Library")
    data object Discover : NavigationItem("discover", R.drawable.ic_discover, "Discover")
    data object Setting : NavigationItem("setting", R.drawable.ic_setting, "Settings")
}