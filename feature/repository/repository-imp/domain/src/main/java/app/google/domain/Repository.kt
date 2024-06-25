package app.google.domain

import app.google.domain.model.RepositoryDetail
import app.google.domain.model.RepositoryInfo


interface Repository {
    fun getRepositoryInfo(): RepositoryInfo?

    suspend fun getRepositoryDetail(name: String): RepositoryDetail?
}
