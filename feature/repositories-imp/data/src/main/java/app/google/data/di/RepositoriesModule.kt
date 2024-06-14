package app.google.data.di

import app.google.data.RepositoryImp
import app.google.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun provideRepositoryImp(repositoryImp: RepositoryImp): Repository
}
