package dev.theuzfaleiro.maybetoday.data.repository

import dev.theuzfaleiro.database.domain.model.Task
import dev.theuzfaleiro.maybetoday.data.datasource.ITaskDataSource
import dev.theuzfaleiro.maybetoday.domain.repository.ITaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDataSource: ITaskDataSource) : ITaskRepository {
    override fun getAllTasks(): Flow<List<Task>> = taskDataSource.getAllTasks()
}
