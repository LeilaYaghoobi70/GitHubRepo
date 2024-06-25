package app.google.domain.interactor

import app.google.domain.model.RepositoryDetail
import app.google.domain.model.RepositoryInfo

interface RepositoryInteractor {
    fun getRepositoryInfo(): RepositoryInfo?

    suspend fun getRepositoryDetail(repositoryName: String): RepositoryDetail?

}
