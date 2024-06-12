package com.example.funnyphysics.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.funnyphysics.Navigation.Screen
import com.example.funnyphysics.R
import com.example.funnyphysics.database.AppDatabase
import kotlinx.coroutines.delay

@Composable
fun SplashView(navController: NavController) {
    val context = LocalContext.current
    LaunchedEffect(key1 = "") {
        delay(3000)
        navController.navigate(Screen.Primary.route) {
            popUpTo(navController.graph.id)
        }
        if (AppDatabase.getInstance(context).getBookDao().getAllInfos().isEmpty()) {
            AddInfo(context)
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "")
    }
}