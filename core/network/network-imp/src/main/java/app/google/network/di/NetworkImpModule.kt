package app.google.network.di

import app.google.network.RemoteDataSourceImp
import app.google.network.interceptor.AuthorizationInterceptor
import app.google.network.interceptor.LoggingApolloInterceptor
import app.google.networkapi.RemoteDataSourceApi
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.interceptor.ApolloInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class NetworkImpModule {
    private val BASE_URL = "https://api.github.com/graphql"
    val token = ""

    @Named("loggingApolloInterceptor")
    @Provides
    fun provideLoggingApolloInterceptor(): ApolloInterceptor = LoggingApolloInterceptor()

    @Named("authorizationInterceptor")
    @Provides
    fun provideAuthorizationInterceptor(): ApolloInterceptor = AuthorizationInterceptor(token)

    @Provides
    @NetworkScope
    fun apolloClient(
        @Named("authorizationInterceptor")
        authorizationInterceptor: ApolloInterceptor,
        @Named("loggingApolloInterceptor")
        apolloInterceptor: ApolloInterceptor,
    ): ApolloClient =
        ApolloClient.builder()
            .serverUrl(BASE_URL)
            .addInterceptors(listOf(authorizationInterceptor, apolloInterceptor))
            .build()

    @Provides
    @NetworkScope
    fun provideRemoteDataSource(remoteDataSourceApi: RemoteDataSourceImp): RemoteDataSourceApi = remoteDataSourceApi

}
