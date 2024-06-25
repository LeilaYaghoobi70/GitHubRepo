package app.google.domain.interactor

import app.google.domain.model.RepositoryInfo
import app.google.domain.model.ViewerInfoModel
import app.google.domain.repository.Repository
import javax.inject.Inject

class RepositoriesInteractorImp @Inject constructor(
    private val repository: Repository,
) : RepositoriesInteractor {
    override suspend fun getRepositories(): List<RepositoryInfo>? =
        repository.getRepositories()?.filterNotNull()

    override fun saveSelectedRepo(repositoryInfo: RepositoryInfo) {
        repository.repositoryInfo = repositoryInfo
    }

    override suspend fun getViewerInfo(): ViewerInfoModel =
        repository.getViewerInfo()

}
