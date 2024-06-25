package app.google.data

import app.google.data.mapper.toApiModel
import app.google.repositories_api.RepositoriesAPI
import app.google.repositories_api.model.RepositoryInfo
import javax.inject.Inject

class RepositoriesApiImp @Inject constructor(
    private val repositoryImp: RepositoryImp
) : RepositoriesAPI {
    override var repositoryInfo: RepositoryInfo? = repositoryImp.repositoryInfo?.toApiModel()
}
