package com.example.lab1_md18306

enum class Screen {
    HOME,
    LOGIN,
}

sealed class NavigationItem(val route: String) {
    object Login : NavigationItem(Screen.LOGIN.name)
    object Home : NavigationItem(Screen.HOME.name)
}