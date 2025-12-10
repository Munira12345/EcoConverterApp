package com.example.ecoconverterapp.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecoconverterapp.ui.screens.EcoScreen
import com.example.ecoconverterapp.ui.screens.HistoryScreen
import com.example.ecoconverterapp.ui.screens.ResultsScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "eco_screen"
    ) {
        composable("eco_screen") {
            EcoScreen(navController)

        }
        composable("history") { HistoryScreen() }
       // composable("results") { ResultsScreen() }

        // Add more screens later:
        // composable("results") { ResultsScreen() }

    }
}
