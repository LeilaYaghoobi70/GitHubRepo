package app.google.network.di

import app.google.network.interceptor.AuthorizationInterceptor
import app.google.network.interceptor.LoggingApolloInterceptor
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.interceptor.ApolloInterceptor
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
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
    @RepositoryImpScope
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

}
