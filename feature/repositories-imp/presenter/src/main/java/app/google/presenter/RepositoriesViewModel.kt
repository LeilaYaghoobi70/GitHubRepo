package app.google.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.google.domain.interactor.RepositoriesInteractor
import app.google.domain.model.RepositoryModel
import app.google.presenter.contract.RepositoriesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
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
            _uiState.update {
                it.copy(
                    repositories = repositoriesInteractor.getRepositories(),
                    loading = false,
                    showErrorMessage = false,
                )
            }
        }
    }

    fun saveSelectedRepo(repositoryModel: RepositoryModel) {
        repositoriesInteractor.saveSelectedRepo(repositoryModel = repositoryModel)
    }
}
