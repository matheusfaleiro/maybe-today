package dev.theuzfaleiro.maybetoday.presentation.dashboard.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dev.theuzfaleiro.maybetoday.R
import dev.theuzfaleiro.maybetoday.databinding.FragmentDashboardBinding
import dev.theuzfaleiro.maybetoday.presentation.dashboard.viewmodel.DashboardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val dashboardViewModel by viewModel<DashboardViewModel>()

    private lateinit var dashboardBinding: FragmentDashboardBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBinding(view)
    }

    private fun setUpBinding(view: View) {
        dashboardBinding = FragmentDashboardBinding.bind(view)
        dashboardBinding.includeImportantAndUrgent.textViewNumberOfTasks.text = "3"
        dashboardBinding.includeImportantAndNotUrgent.textViewNumberOfTasks.text = "8"
        dashboardBinding.includeUrgentNotImportant.textViewNumberOfTasks.text = "2"
        dashboardBinding.includeNotImportantNotUrgent.textViewNumberOfTasks.text = "5"
    }
}
