package app.google.data

import app.google.data.mapper.toDomain
import app.google.domain.model.RepositoryInfo
import app.google.domain.model.ViewerInfoModel
import app.google.networkapi.RepositoriesRemoteDataSourceApi
import javax.inject.Inject
import app.google.domain.repository.Repository

class RepositoryImp @Inject constructor(
    private val repositoriesRemoteDataSourceApi: RepositoriesRemoteDataSourceApi,
) : Repository {
    override var repositoryInfo: RepositoryInfo? = null

    override suspend fun getRepositories(): List<RepositoryInfo?>? =
        repositoriesRemoteDataSourceApi.getRepositories()?.map {
            it?.toDomain()
        }

    override suspend fun getViewerInfo(): ViewerInfoModel =
       repositoriesRemoteDataSourceApi.getViewerInfo().toDomain()

}
