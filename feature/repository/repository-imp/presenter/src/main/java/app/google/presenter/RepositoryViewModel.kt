package app.google.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.google.domain.interactor.RepositoryInteractor
import app.google.domain.model.RepositoryInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryViewModel @Inject constructor(
    private val repositoryInteractor: RepositoryInteractor,
) : ViewModel() {
    init {
        repositoryInteractor.getRepositoryInfo()?.let { repositoryInfo: RepositoryInfo ->
            viewModelScope.launch {
                repositoryInteractor.getRepositoryDetail(repositoryInfo.name)
            }
        }
    }
}
