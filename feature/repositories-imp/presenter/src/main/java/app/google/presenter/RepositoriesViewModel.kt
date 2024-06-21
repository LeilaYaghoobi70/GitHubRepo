package app.google.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.google.domain.interactor.RepositoriesInteractor
import app.google.domain.model.RepositoryModel
import app.google.domain.model.ViewerInfoModel
import app.google.presenter.contract.RepositoriesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    private val repositoriesInteractor: RepositoriesInteractor,
) : ViewModel() {

    private val _uiState: MutableStateFlow<RepositoriesState> =
        MutableStateFlow(RepositoriesState())

    val uiState =
        _uiState.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = RepositoriesState(),
        )

    init {
        getRepositories()
    }

    private fun getRepositories() {
        viewModelScope.launch(CoroutineExceptionHandler { _, _ ->
            _uiState.update {
                it.copy(loading = false, showErrorMessage = true)
            }
        }) {
            _uiState.update {
                it.copy(loading = true)
            }
            val repositories = async { repositoriesInteractor.getRepositories() }.await()
            val viewerInfo = async { repositoriesInteractor.getViewerInfo() }.await()

            _uiState.update {
                it.copy(
                    repositories = repositories,
                    loading = false,
                    showErrorMessage = false,
                    viewerInfoModel = viewerInfo,
                )
            }
        }
    }

    fun saveSelectedRepo(repositoryModel: RepositoryModel) {
        repositoriesInteractor.saveSelectedRepo(repositoryModel = repositoryModel)
    }
}
