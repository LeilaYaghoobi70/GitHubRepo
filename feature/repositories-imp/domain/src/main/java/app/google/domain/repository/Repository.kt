package app.google.domain.repository

import app.google.domain.model.RepositoryModel

interface Repository {
    var repositoryModel: RepositoryModel?

    suspend fun getRepositories(): List<RepositoryModel?>?
}
