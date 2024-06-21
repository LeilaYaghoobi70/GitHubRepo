package app.google.domain.interactor

import app.google.domain.model.RepositoryModel
import app.google.domain.model.ViewerInfoModel

interface RepositoriesInteractor {
    suspend fun getRepositories(): List<RepositoryModel>?

    fun saveSelectedRepo(repositoryModel: RepositoryModel)

    suspend fun getViewerInfo(): ViewerInfoModel
}
