package com.example.cvs.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cvs.presentation.flickr.FlickrDetailsScreen
import com.example.cvs.presentation.flickr.FlickrListScreen

@Composable
fun CvsNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = FLICKR_LIST_SCREEN) {
        composable(route = FLICKR_LIST_SCREEN) {
            FlickrListScreen() { navController.navigate(FLICKR_DETAILS_SCREEN) }
        }

        composable(route = FLICKR_DETAILS_SCREEN) {
            FlickrDetailsScreen()
        }
    }
}