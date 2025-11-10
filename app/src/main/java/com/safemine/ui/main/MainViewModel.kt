package com.safemine.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.safemine.data.model.Alert​​
import com.safemine.data.repository.FakeRepository​​

/**
* Comparte el estado de alto nivel de la aplicación en todos los destinos de nivel superior.
*/
clase MainViewModel (
 
    private val repository: FakeRepository = FakeRepository()
 
): ViewModel() {

    private val _activeAlerts = MutableLiveData<List<Alert>>()
 
    val activeAlerts: LiveData<List<Alert>> = _activeAlerts

    calor {
        cargarAlertas()
    }

    función privada cargarAlertas () {
  
        _activeAlerts.value = repository.getActiveAlerts()
    }
}