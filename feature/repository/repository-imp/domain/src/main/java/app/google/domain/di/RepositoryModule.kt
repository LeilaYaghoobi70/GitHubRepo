package app.google.domain.di

import app.google.domain.interactor.RepositoryInteractor
import app.google.domain.interactor.RepositoryInteractorImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepositoryInteractor(
        repositoryInteractor: RepositoryInteractorImp,
    ): RepositoryInteractor
}
