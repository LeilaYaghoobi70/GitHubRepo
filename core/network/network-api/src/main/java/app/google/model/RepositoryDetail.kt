package app.google.model

data class RepositoryDetail(
    val nameWithOwner: String,
    val updatedAt: String,
    val createdAt: String,
    val description: String?,
    val pushedAt: String?,
)