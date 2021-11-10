package dev.theuzfaleiro.maybetoday.data.datasource

import dev.theuzfaleiro.database.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface ITaskDataSource {
    fun getAllTasks(): Flow<List<Task>>
}
