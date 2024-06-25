package app.google.networkapi

import app.google.model.RepositoryDetail

interface RepositoryRemoteDataSourceApi {
    suspend fun getRepositoryDetail(name: String): RepositoryDetail?
}
