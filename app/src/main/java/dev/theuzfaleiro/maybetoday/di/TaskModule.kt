package dev.theuzfaleiro.maybetoday.di

import dev.theuzfaleiro.maybetoday.data.datasource.ITaskDataSource
import dev.theuzfaleiro.maybetoday.data.datasource.TaskDataSource
import dev.theuzfaleiro.maybetoday.data.repository.TaskRepository
import dev.theuzfaleiro.maybetoday.domain.repository.ITaskRepository
import dev.theuzfaleiro.maybetoday.domain.usecase.GetTasks
import dev.theuzfaleiro.maybetoday.presentation.dashboard.viewmodel.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val taskModule = module {

    viewModel {
        DashboardViewModel(getTasks = get())
    }

    single {
        GetTasks(taskRepository = get())
    }

    single<ITaskRepository> {
        TaskRepository(taskDataSource = get())
    }

    single<ITaskDataSource> {
        TaskDataSource(taskDao = get())
    }
}
