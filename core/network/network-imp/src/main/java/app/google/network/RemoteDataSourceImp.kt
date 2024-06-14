package app.google.network

import app.google.model.Repository
import app.google.networkapi.RemoteDataSourceApi
import com.apollographql.apollo3.ApolloClient
import com.example.UserRepositoryListQuery
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val apolloClient: ApolloClient
) : RemoteDataSourceApi {
    override suspend fun getRepositories(): List<Repository?>? {
        val userRepositoryList: UserRepositoryListQuery.Data =
            apolloClient.query(UserRepositoryListQuery("")).execute().dataAssertNoErrors
        return userRepositoryList.user.repositories.edges?.map {
            it?.node?.repositoryFields?.run {
                Repository(
                    id = this.id,
                    name = this.name,
                    description = this.description,
                    url = this.url,
                )
            }
        }
    }
}