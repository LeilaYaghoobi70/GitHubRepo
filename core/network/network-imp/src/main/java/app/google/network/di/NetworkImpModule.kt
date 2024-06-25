package app.google.network.di

import app.google.network.BuildConfig
import app.google.network.RepositoriesRemoteDataSourceImp
import app.google.network.RepositoryRemoteDataSourceImp
import app.google.network.interceptor.AuthorizationInterceptor
import app.google.network.interceptor.LoggingApolloInterceptor
import app.google.networkapi.RepositoriesRemoteDataSourceApi
import app.google.networkapi.RepositoryRemoteDataSourceApi
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.interceptor.ApolloInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkImpModule {
    @Named("loggingApolloInterceptor")
    @Provides
    fun provideLoggingApolloInterceptor(): ApolloInterceptor = LoggingApolloInterceptor()

    @Named("authorizationInterceptor")
    @Provides
    fun provideAuthorizationInterceptor(): ApolloInterceptor =
        AuthorizationInterceptor(BuildConfig.GITHUB_TOKEN)

    @Provides
    @Singleton
    fun apolloClient(
        @Named("authorizationInterceptor")
        authorizationInterceptor: ApolloInterceptor,
        @Named("loggingApolloInterceptor")
        apolloInterceptor: ApolloInterceptor,
    ): ApolloClient =
        ApolloClient.Builder()
            .serverUrl(BuildConfig.BASE_URL)
            .webSocketIdleTimeoutMillis(10000)
            .addInterceptors(listOf(authorizationInterceptor, apolloInterceptor))
            .build()

    @Provides
    @Singleton
    fun provideRepositoriesRemoteDataSource(repositoriesRemoteDataSource: RepositoriesRemoteDataSourceImp): RepositoriesRemoteDataSourceApi =
        repositoriesRemoteDataSource

    @Provides
    @Singleton
    fun provideRepositoryRemoteDataSource(repositoryRemoteDataSource: RepositoryRemoteDataSourceImp): RepositoryRemoteDataSourceApi =
        repositoryRemoteDataSource

}
