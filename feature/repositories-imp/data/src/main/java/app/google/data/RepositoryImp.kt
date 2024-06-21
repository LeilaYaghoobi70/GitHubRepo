package app.google.data

import app.google.data.mapper.toDomain
import app.google.domain.model.RepositoryModel
import app.google.domain.model.ViewerInfoModel
import app.google.networkapi.RemoteDataSourceApi
import javax.inject.Inject
import app.google.domain.repository.Repository

class RepositoryImp @Inject constructor(
    private val remoteDataSourceApi: RemoteDataSourceApi,
) : Repository {
    override var repositoryModel: RepositoryModel? = null

    override suspend fun getRepositories(): List<RepositoryModel?>? =
        remoteDataSourceApi.getRepositories()?.map {
            it?.toDomain()
        }

    override suspend fun getViewerInfo(): ViewerInfoModel =
       remoteDataSourceApi.getViewerInfo().toDomain()

}
