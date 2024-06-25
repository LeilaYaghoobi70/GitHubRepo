package app.google.domain.interactor

import app.google.domain.model.RepositoryInfo
import app.google.domain.model.ViewerInfoModel

interface RepositoriesInteractor {
    suspend fun getRepositories(): List<RepositoryInfo>?

    fun saveSelectedRepo(repositoryInfo: RepositoryInfo)

    suspend fun getViewerInfo(): ViewerInfoModel
}
