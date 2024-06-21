package app.google.presenter.contract

import app.google.domain.model.RepositoryModel

data class RepositoriesAction(
    val navigateToDetail: (RepositoryModel) -> (Unit)
)
