package app.google.data.mapper

import app.google.domain.model.RepositoriesModel
import app.google.model.Repository

fun Repository.toDomain() = RepositoriesModel(
    id = id,
    name = name,
    description = description,
    url = url
)