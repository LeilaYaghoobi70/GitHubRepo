package app.google.domain.di

import app.google.domain.interactor.RepositoriesInteractor
import app.google.domain.interactor.RepositoriesInteractorImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun provideRepositoriesInteractor(
        repositoriesInteractorImp: RepositoriesInteractorImp,
    ): RepositoriesInteractor
}
