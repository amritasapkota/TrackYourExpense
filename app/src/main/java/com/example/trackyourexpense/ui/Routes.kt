package com.example.trackyourexpense.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trackyourexpense.ui.RouteDef
import com.example.trackyourexpense.ui.views.DashBoardView

@Composable
fun Routes(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = RouteDef.getStartDestination().routeName,
        modifier = modifier
    ) {
        composable(RouteDef.DashBoard.routeName) {
            DashBoardView()
        }

        composable(RouteDef.CarParkList.routeName) {
        }
    }
}
