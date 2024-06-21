package app.google.githubrepo.ui.navigator

import androidx.navigation.NavHostController

class NavigationActions(
    private val navHostController: NavHostController,
) {
    val navigateToDetail: () -> Unit = {
        navHostController.navigate(Destinations.REPOSITORY_DETAIL)
    }
}
