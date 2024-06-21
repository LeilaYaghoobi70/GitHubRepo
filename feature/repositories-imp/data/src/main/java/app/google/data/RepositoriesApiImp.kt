package app.google.data

import app.google.data.mapper.toApiModel
import app.google.repositories_api.RepositoriesAPI
import app.google.repositories_api.model.RepositoryModel
import javax.inject.Inject

class RepositoriesApiImp @Inject constructor(
    private val repositoryImp: RepositoryImp
) : RepositoriesAPI {
    override var repositoryModel: RepositoryModel? = repositoryImp.repositoryModel?.toApiModel()
}
