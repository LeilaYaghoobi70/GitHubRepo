package app.google.domain.repository

import app.google.domain.model.RepositoryModel
import app.google.domain.model.ViewerInfoModel

interface Repository {
    var repositoryModel: RepositoryModel?

    suspend fun getRepositories(): List<RepositoryModel?>?

    suspend fun getViewerInfo(): ViewerInfoModel
}
