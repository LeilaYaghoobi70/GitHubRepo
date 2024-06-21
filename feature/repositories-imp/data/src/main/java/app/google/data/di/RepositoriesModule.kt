package app.google.data.di

import app.google.data.RepositoriesApiImp
import app.google.data.RepositoryImp
import app.google.domain.repository.Repository
import app.google.repositories_api.RepositoriesAPI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun provideRepositoryImp(repositoryImp: RepositoryImp): Repository

    @Binds
    abstract fun provideRepositoriesAPI(repositoriesApiImp: RepositoriesApiImp): RepositoriesAPI

}
