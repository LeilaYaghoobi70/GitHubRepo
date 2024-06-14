package app.google.domain.interactor

import app.google.domain.model.RepositoriesModel

interface RepositoriesInteractor {
    suspend fun getRepositories(): List<RepositoriesModel?>?
}