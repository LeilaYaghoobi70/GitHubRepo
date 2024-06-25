package app.google.domain.interactor

import app.google.domain.Repository
import app.google.domain.model.RepositoryDetail
import app.google.domain.model.RepositoryInfo

class RepositoryInteractorImp(
    private val repository: Repository,
) : RepositoryInteractor {
    override fun getRepositoryInfo(): RepositoryInfo? =
        repository.getRepositoryInfo()

    override suspend fun getRepositoryDetail(repositoryName: String): RepositoryDetail? =
        repository.getRepositoryDetail(name = repositoryName)

}
