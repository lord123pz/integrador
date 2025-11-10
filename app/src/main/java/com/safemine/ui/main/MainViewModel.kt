package com.safemine.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.safemine.data.model.Alert
import com.safemine.data.repository.FakeRepository

/**
 * Shares high level app state across top-level destinations.
 */
class MainViewModel(
    private val repository: FakeRepository = FakeRepository()
) : ViewModel() {

    private val _activeAlerts = MutableLiveData<List<Alert>>()
    val activeAlerts: LiveData<List<Alert>> = _activeAlerts

    init {
        loadAlerts()
    }

    private fun loadAlerts() {
        _activeAlerts.value = repository.getActiveAlerts()
    }
}
