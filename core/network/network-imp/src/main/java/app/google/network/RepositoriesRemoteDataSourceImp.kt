package app.google.network


import app.google.UserRepositoryListQuery
import app.google.ViewerInfoQuery
import app.google.model.Repository
import app.google.model.ViewerInfo
import app.google.networkapi.RepositoriesRemoteDataSourceApi
import com.apollographql.apollo3.ApolloClient

import javax.inject.Inject

class RepositoriesRemoteDataSourceImp @Inject constructor(
    private val apolloClient: ApolloClient
) : RepositoriesRemoteDataSourceApi {
    override suspend fun getRepositories(): List<Repository?>? {
        val userRepositoryList: UserRepositoryListQuery.Data =
            apolloClient.query(UserRepositoryListQuery(first = 20)).execute().dataAssertNoErrors
        return userRepositoryList.viewer.repositories.edges?.map {
            it?.node?.repositoryFields?.run {
                Repository(
                    id = id,
                    name = name,
                    description = description,
                    url = url,
                )
            }
        }
    }

    override suspend fun getViewerInfo(): ViewerInfo =
        apolloClient.query(ViewerInfoQuery()).execute().data!!.viewer.let {
            ViewerInfo(login = it.login, name = it.name, email = it.email, avatarUrl = it.avatarUrl as String)
        }

}
