package app.google.domain.repository

import app.google.domain.model.RepositoriesModel

interface Repository {
    suspend fun getRepositories(): List<RepositoriesModel?>?
}