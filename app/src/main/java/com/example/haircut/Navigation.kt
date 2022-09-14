package com.example.haircut

import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Test") },
        backgroundColor = Color.Gray,
        contentColor = Color.White

    )
}

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Favorites,
        NavigationItem.Account
    )
    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Magenta,
                alwaysShowLabel = true,
                selected = false,
                onClick = {

                }
            )
            }
        }
    }

    sealed class NavigationItem(
        var route: String,
        var icon: Int,
        var title: String
    ) {
        object Home : NavigationItem(
            route = "home",
            icon = R.drawable.ic_baseline_grid_on_24,
            title = "grid"
        )

        object Favorites : NavigationItem(
            route = "favorites",
            icon = R.drawable.ic_baseline_favorite_border_24,
            title = "favorites"
        )

        object Account : NavigationItem(
            route = "account",
            icon = R.drawable.ic_baseline_person_outline_24,
            title = "account"
        )
    }