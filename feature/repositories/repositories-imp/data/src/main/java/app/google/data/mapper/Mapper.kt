package app.google.data.mapper

import app.google.domain.model.RepositoryInfo
import app.google.domain.model.ViewerInfoModel
import app.google.model.Repository
import app.google.model.ViewerInfo
import app.google.repositories_api.model.RepositoryInfo as RepositoryModelInfo

fun Repository.toDomain() =
    RepositoryInfo(
        id = id,
        name = name,
        description = description,
        url = url,
    )

fun RepositoryInfo.toApiModel() =
    RepositoryModelInfo(
        id = id,
        name = name,
        description = description,
        url = url,
    )

fun ViewerInfo.toDomain() = ViewerInfoModel(
    login = login,
    name = name,
    email = email,
)
