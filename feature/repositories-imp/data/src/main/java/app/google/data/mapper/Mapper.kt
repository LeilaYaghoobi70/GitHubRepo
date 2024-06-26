package app.google.data.mapper

import app.google.domain.model.RepositoryModel
import app.google.domain.model.ViewerInfoModel
import app.google.model.Repository
import app.google.model.ViewerInfo
import app.google.repositories_api.model.RepositoryModel as RepositoryModelApi

fun Repository.toDomain() =
    RepositoryModel(
        id = id,
        name = name,
        description = description,
        url = url,
    )

fun RepositoryModel.toApiModel() =
    RepositoryModelApi(
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
