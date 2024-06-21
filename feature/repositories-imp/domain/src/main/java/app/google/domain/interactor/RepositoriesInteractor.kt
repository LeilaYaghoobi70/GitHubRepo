package app.google.domain.interactor

import app.google.domain.model.RepositoryModel

interface RepositoriesInteractor {
    suspend fun getRepositories(): List<RepositoryModel>?

    fun saveSelectedRepo(repositoryModel: RepositoryModel)
}
