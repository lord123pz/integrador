package com.safemine.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.safemine.data.model.Alert
import com.safemine.data.repository.FakeRepository

class DashboardViewModel(private val repo: FakeRepository) : ViewModel() {

    private val _activeAlerts = MutableLiveData<List<Alert>>()
    val activeAlerts: LiveData<List<Alert>> = _activeAlerts

    init {
        _activeAlerts.value = repo.getActiveAlerts()
    }

    class Factory(private val repo: FakeRepository) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DashboardViewModel(repo) as T
        }
    }
}
