package dev.theuzfaleiro.maybetoday.domain.repository

import dev.theuzfaleiro.database.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface ITaskRepository {
    fun getAllTasks(): Flow<List<Task>>
}
