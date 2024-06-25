package app.google.di

import app.google.data.RepositoryImp
import app.google.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepositoryImp(repositoryImp: RepositoryImp): Repository
}
