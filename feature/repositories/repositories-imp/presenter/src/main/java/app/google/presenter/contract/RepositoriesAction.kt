package app.google.presenter.contract

import app.google.domain.model.RepositoryInfo

data class RepositoriesAction(
    val navigateToDetail: (RepositoryInfo) -> (Unit)
)
