package com.example.trackyourexpense

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trackyourexpense.ui.RouteDef
import com.example.trackyourexpense.ui.Routes
import com.example.trackyourexpense.ui.theme.TrackYourExpenseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            val currentRoute by navController.currentRouteAsState()
            val scaffoldState = rememberScaffoldState()
            TrackYourExpenseTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {},
                    drawerContent = {},
                    drawerShape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    val bottomPadding = it.calculateBottomPadding()
                    Routes(
                        navController = navController,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun NavHostController.currentRouteAsState(): State<RouteDef> {
    val routeChange by this.currentBackStackEntryFlow.collectAsState(initial = null)
    return remember(routeChange) { mutableStateOf(this.currentRoute()) }
}

fun NavHostController.currentRoute(): RouteDef {
    val currentRoute = this.currentBackStackEntry
        ?.destination
        ?.route
        ?.let { RouteDef.route(it) }

    if (currentRoute != null) {
        return currentRoute
    }
    return RouteDef.getStartDestination()
}