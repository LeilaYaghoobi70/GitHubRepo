package app.google.githubrepo.ui.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.google.presenter.view.RepositoriesScreen

@Composable
fun Navigator(
    navHostController: NavHostController,
) {
    val actions = remember { NavigationActions(navHostController) }

    NavHost(
        navController = navHostController,
        startDestination = Destinations.REPOSITORIES,
    ) {
        composable(route = Destinations.REPOSITORIES) {
            RepositoriesScreen(
                repositoriesViewModel = hiltViewModel(),
                navigateToDetail = actions.navigateToDetail,
            )
        }
    }
}
