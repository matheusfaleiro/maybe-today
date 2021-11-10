package dev.theuzfaleiro.maybetoday.presentation.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import dev.theuzfaleiro.maybetoday.domain.usecase.GetTasks

class DashboardViewModel(private val getTasks: GetTasks) : ViewModel()
