package app.google.network


import app.google.GetRepositoryInfoQuery
import app.google.model.RepositoryDetail
import app.google.networkapi.RepositoryRemoteDataSourceApi
import com.apollographql.apollo3.ApolloClient
import javax.inject.Inject

class RepositoryRemoteDataSourceImp @Inject constructor(
    private val apolloClient: ApolloClient
) : RepositoryRemoteDataSourceApi {
    override suspend fun getRepositoryDetail(name: String): RepositoryDetail? =
        apolloClient.query(GetRepositoryInfoQuery(name = name)).execute().data?.repository?.let {
            RepositoryDetail(
                it.nameWithOwner,
                it.updatedAt as String,
                it.pushedAt as String,
                it.description,
                it.createdAt as String?,
            )
        }

}
