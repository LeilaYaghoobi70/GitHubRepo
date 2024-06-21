package app.google.presenter.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.google.domain.model.RepositoryModel
import app.google.presenter.contract.RepositoriesState

@Composable
fun RepositoriesBody(
    repositoriesState: RepositoriesState,
    navigateToDetail: (RepositoryModel) -> (Unit),
) {
    val itemModifier: Modifier =
        Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(MaterialTheme.colorScheme.onSecondary)
            .padding(8.dp)

    repositoriesState.repositories?.let { repositories ->
        LazyColumn(
            userScrollEnabled = true,
        ) {
            items(repositories.size) {
                RepositoryItem(
                    repositoryModel = repositories[it],
                    modifier = itemModifier,
                    navigateToDetail = navigateToDetail,
                )
            }
        }
    }
}

@Composable
fun RepositoryItem(
    repositoryModel: RepositoryModel,
    modifier: Modifier,
    navigateToDetail: (RepositoryModel) -> (Unit),
) {
    Column(
        modifier = modifier.clickable {
            navigateToDetail(repositoryModel)
        },
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = repositoryModel.name,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.titleSmall.fontSize,
        )
        repositoryModel.description?.let { description: String ->
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = description,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                lineHeight = 12.sp,
            )
        }
        Spacer(modifier = Modifier.height(1.dp))
    }
}
