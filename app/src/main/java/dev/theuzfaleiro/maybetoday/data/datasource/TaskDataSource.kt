package dev.theuzfaleiro.maybetoday.data.datasource

import dev.theuzfaleiro.database.data.dao.TaskDao
import dev.theuzfaleiro.database.domain.model.Task
import kotlinx.coroutines.flow.Flow

class TaskDataSource(private val taskDao: TaskDao) : ITaskDataSource {

    override fun getAllTasks(): Flow<List<Task>> = taskDao.getAllTasks()
}
