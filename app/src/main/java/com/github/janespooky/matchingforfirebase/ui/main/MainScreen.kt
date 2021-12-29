package com.github.janespooky.matchingforfirebase.ui.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.janespooky.matchingforfirebase.R

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {
        Navigation(navController)
    }
}

@Composable
private fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        MainNavigationItem.List,
        MainNavigationItem.Card,
        MainNavigationItem.Square,
        MainNavigationItem.Talk,
        MainNavigationItem.Narrative
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.purple_200),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(painter = painterResource(id = item.icon), contentDescription = item.title)
                },
                label = {
                    Text(text = item.title)
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = MainNavigationItem.Square.route) {
        composable(MainNavigationItem.List.route) {
            ListScreen()
        }
        composable(MainNavigationItem.Card.route) {
            CardScreen()
        }
        composable(MainNavigationItem.Square.route) {
            SquareScreen()
        }
        composable(MainNavigationItem.Talk.route) {
            TalkScreen()
        }
        composable(MainNavigationItem.Narrative.route) {
            NarrativeScreen()
        }
    }
}