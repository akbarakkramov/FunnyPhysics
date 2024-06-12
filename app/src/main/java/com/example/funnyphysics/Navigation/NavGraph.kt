package com.example.funnyphysics.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.funnyphysics.database.AppDatabase
import com.example.funnyphysics.screens.detail.DetailView
import com.example.funnyphysics.screens.detail.DetailViewModel
import com.example.funnyphysics.screens.primary.PrimaryModel
import com.example.funnyphysics.screens.primary.PrimaryView
import com.example.funnyphysics.screens.primary.PrimaryViewModel
import com.example.funnyphysics.screens.splash.SplashView

@Composable
fun AppNavigation(navController: NavHostController) {
    val db = AppDatabase.getInstance(LocalContext.current)
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashView(navController = navController)
        }
        composable(route = Screen.Primary.route) {
            val primaryModel = PrimaryModel(db)
            val primaryViewModel = PrimaryViewModel(primaryModel, navController)
            PrimaryView(primaryViewModel)
        }
        composable(Screen.Detail.route, arguments = listOf(navArgument("id") {
            type = NavType.IntType
        })) {
            val id = it.arguments?.getInt("id")!!
            val book = db.getInfoDao().getInfo(id)
            val primaryModel = PrimaryModel(db)
            val dvm = DetailViewModel(primaryModel)
            DetailView(dvm = dvm, navController = navController, book)
        }
    }
}
