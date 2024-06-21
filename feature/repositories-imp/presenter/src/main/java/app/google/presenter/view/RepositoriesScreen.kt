package app.google.presenter.view

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import app.google.domain.model.RepositoryModel
import app.google.presenter.R
import app.google.presenter.RepositoriesViewModel
import app.google.presenter.contract.RepositoriesAction

@Composable
fun RepositoriesScreen(
    repositoriesViewModel: RepositoriesViewModel,
    navigateToDetail: () -> (Unit),
) {
    val uiState by repositoriesViewModel.uiState.collectAsState()
    val action = RepositoriesAction(
        navigateToDetail = { repositoryModel: RepositoryModel ->
            repositoriesViewModel.saveSelectedRepo(repositoryModel = repositoryModel)
            navigateToDetail()
        },
    )

    AnimatedVisibility(visible = uiState.showErrorMessage) {
        Toast.makeText(
            LocalContext.current,
            stringResource(id = R.string.error_message),
            Toast.LENGTH_LONG,
        ).show()
    }
    RepositoriesBody(
        repositoriesState = uiState,
        navigateToDetail = action.navigateToDetail,
    )
}
