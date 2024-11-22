package com.prg.imagefactory.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.prg.imagefactory.presentation.favorites_screen.FavoritesScreen
import com.prg.imagefactory.presentation.home_screen.HomeScreen
import com.prg.imagefactory.presentation.home_screen.HomeViewModel
import com.prg.imagefactory.presentation.search_screen.SearchScreen
import com.prg.imagefactory.presentation.full_image_screen.FullImageScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraphSetup(
    navController: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen
    ) {
        composable<Routes.HomeScreen>{
            val viewModel = viewModel<HomeViewModel>()

            HomeScreen(
                scrollBehavior = scrollBehavior,
                images = viewModel.images,
                onImageClick = { imageId ->
                    navController.navigate(Routes.FullImageScreen(imageId))
                },
                onSearchClick = {
                    navController.navigate(Routes.SearchScreen)
                },
                onFABClick = {
                    navController.navigate(Routes.FavoritesScreen)
                }
            )
        }
        composable<Routes.SearchScreen>{
            SearchScreen(
                onBackClick = {navController.navigateUp()}
            )
        }
        composable<Routes.FavoritesScreen>{
            FavoritesScreen(
                onBackClick = {navController.navigateUp()}
            )
        }
        composable<Routes.FullImageScreen>{  backStackEntry ->
            val imageId = backStackEntry.toRoute<Routes.FullImageScreen>().imageId
           FullImageScreen(
               imageId = imageId,
               onBackClick = {navController.navigateUp()}

           )
        }
    }
}