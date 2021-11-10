package dev.theuzfaleiro.maybetoday.domain.usecase

import dev.theuzfaleiro.database.domain.model.Task
import dev.theuzfaleiro.maybetoday.domain.repository.ITaskRepository
import kotlinx.coroutines.flow.Flow

class GetTasks(private val taskRepository: ITaskRepository) {
    operator fun invoke(): Flow<List<Task>> = taskRepository.getAllTasks()
}
