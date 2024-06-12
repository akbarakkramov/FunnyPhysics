package com.example.funnyphysics.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.funnyphysics.screens.home.HomeView
import com.example.funnyphysics.screens.primary.PrimaryViewModel
import com.example.funnyphysics.screens.saved.SavedView

@Composable
fun BottomNavGraph(pvm: PrimaryViewModel, bottomNavController: NavHostController) {
    NavHost(navController = bottomNavController, startDestination = BottomNavScreen.Home.route) {
        composable(route = BottomNavScreen.Home.route) {
            HomeView(pvm = pvm)
        }
        composable(route = BottomNavScreen.Saved.route) {
            SavedView(pvm = pvm)
        }
    }
}