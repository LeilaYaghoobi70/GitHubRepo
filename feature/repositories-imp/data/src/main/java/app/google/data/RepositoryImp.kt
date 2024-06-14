package app.google.data


import app.google.data.mapper.toDomain
import app.google.domain.model.RepositoriesModel
import app.google.networkapi.RemoteDataSourceApi
import javax.inject.Inject
import  app.google.domain.repository.Repository

class RepositoryImp @Inject
constructor(
    private val remoteDataSourceApi: RemoteDataSourceApi,
) : Repository {
    override suspend fun getRepositories(): List<RepositoriesModel?>? =
        remoteDataSourceApi.getRepositories()?.map {
            it?.toDomain()
        }

}
