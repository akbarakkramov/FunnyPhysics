package com.example.funnyphysics.screens.primary

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.funnyphysics.Navigation.BottomNavScreen

@Composable
fun BottomNavigationBar(bottomNavController: NavController) {
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomNavigation(backgroundColor = Color.White, elevation = 0.dp) {
        BottomNavScreen.all().forEach {
            BottomNavigationItem(selected = currentRoute == it.route,
                onClick = { if (currentRoute != it.route) bottomNavController.navigate(it.route) },
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = "",
                        tint = if (it.route == currentRoute) Color(0xFF1A9CFF) else Color(0xFFB8B8B8)
                    )
                })
        }
    }
}