package app.google.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.google.domain.interactor.RepositoriesInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    private val repositoriesInteractor: RepositoriesInteractor,
) : ViewModel() {
    init {
        getRepositories()
    }

    private fun getRepositories() {
        viewModelScope.launch(CoroutineExceptionHandler { _, _ ->
        }) {
            repositoriesInteractor.getRepositories()?.map {
            }
        }
    }
}
