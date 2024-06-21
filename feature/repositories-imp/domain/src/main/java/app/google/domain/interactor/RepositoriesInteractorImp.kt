package app.google.domain.interactor

import app.google.domain.model.RepositoryModel
import app.google.domain.model.ViewerInfoModel
import app.google.domain.repository.Repository
import javax.inject.Inject

class RepositoriesInteractorImp @Inject constructor(
    private val repository: Repository,
) : RepositoriesInteractor {
    override suspend fun getRepositories(): List<RepositoryModel>? =
        repository.getRepositories()?.filterNotNull()

    override fun saveSelectedRepo(repositoryModel: RepositoryModel) {
        repository.repositoryModel = repositoryModel
    }

    override suspend fun getViewerInfo(): ViewerInfoModel =
        repository.getViewerInfo()

}
