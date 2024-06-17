package app.google.githubrepo.ui.navigator

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.google.presenter.RepositoriesScreen

@Composable
fun Navigator(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Destinations.REPOSITORIES,
    ) {
        composable(route = Destinations.REPOSITORIES) {
            RepositoriesScreen(repositoriesViewModel = hiltViewModel())
        }
    }
}
