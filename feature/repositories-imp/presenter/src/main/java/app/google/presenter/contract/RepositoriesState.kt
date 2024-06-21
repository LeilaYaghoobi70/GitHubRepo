package app.google.presenter.contract

import app.google.domain.model.RepositoryModel
import app.google.domain.model.ViewerInfoModel

data class RepositoriesState(
    val repositories: List<RepositoryModel>? = null,
    val loading: Boolean = false,
    val showErrorMessage: Boolean = false,
    val viewerInfoModel: ViewerInfoModel? = null,
)
