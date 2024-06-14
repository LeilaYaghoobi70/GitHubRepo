package app.google.domain.interactor

import app.google.domain.model.RepositoriesModel
import app.google.domain.repository.Repository
import javax.inject.Inject

class RepositoriesInteractorImp @Inject
constructor(
    private val repository: Repository
) : RepositoriesInteractor {
    override suspend fun getRepositories(): List<RepositoriesModel?>? =
        repository.getRepositories()
}