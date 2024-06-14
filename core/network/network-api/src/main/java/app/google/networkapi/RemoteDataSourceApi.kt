package app.google.networkapi

import app.google.model.Repository

interface RemoteDataSourceApi {
    suspend fun getRepositories(): List<Repository?>?
}