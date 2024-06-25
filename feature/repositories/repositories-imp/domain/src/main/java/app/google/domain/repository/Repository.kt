package app.google.domain.repository

import app.google.domain.model.RepositoryInfo
import app.google.domain.model.ViewerInfoModel

interface Repository {
    var repositoryInfo: RepositoryInfo?

    suspend fun getRepositories(): List<RepositoryInfo?>?

    suspend fun getViewerInfo(): ViewerInfoModel
}
