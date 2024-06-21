package app.google.networkapi

import app.google.model.Repository
import app.google.model.ViewerInfo

interface RemoteDataSourceApi {
    suspend fun getRepositories(): List<Repository?>?
    suspend fun getViewerInfo(): ViewerInfo
}
