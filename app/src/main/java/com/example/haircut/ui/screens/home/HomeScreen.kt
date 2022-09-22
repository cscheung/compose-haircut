package com.example.haircut.ui.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.haircut.BottomNavigationBar
import com.example.haircut.Service
import com.example.haircut.TopBar

@Composable
fun HomeScreen(services: ArrayList<Service>) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() },
        content = { padding ->
            ServicesGrid(services = services)
        }
    )
}
