package app.google.data

import app.google.domain.Repository
import app.google.domain.model.RepositoryDetail
import app.google.domain.model.RepositoryInfo
import app.google.model.toDomain
import app.google.networkapi.RepositoryRemoteDataSourceApi
import app.google.repositories_api.RepositoriesAPI


class RepositoryImp(
    private val repositoryRemoteDataSourceApi: RepositoryRemoteDataSourceApi,
    private val repositoriesAPI: RepositoriesAPI,
) : Repository {
    override fun getRepositoryInfo(): RepositoryInfo? =
        repositoriesAPI.repositoryInfo?.toDomain()

    override suspend fun getRepositoryDetail(
        name: String,
    ): RepositoryDetail? =
        repositoryRemoteDataSourceApi.getRepositoryDetail(name)?.toDomain()

}
