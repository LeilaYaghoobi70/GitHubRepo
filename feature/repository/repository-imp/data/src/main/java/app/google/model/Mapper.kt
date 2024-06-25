package app.google.model


import app.google.domain.model.RepositoryDetail
import app.google.domain.model.RepositoryInfo as RepositoryInfoRemote
import app.google.repositories_api.model.RepositoryInfo

import app.google.model.RepositoryDetail as RepositoryDetailRemote

fun RepositoryInfo.toDomain() = RepositoryInfoRemote(
    id,
    name,
    description,
    url as String,
)

fun RepositoryDetailRemote.toDomain() = RepositoryDetail(
    nameWithOwner,
    updatedAt,
    createdAt,
    description,
    pushedAt,
)