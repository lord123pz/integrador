package com.safemine.ui.device

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.safemine.data.model.Device
import com.safemine.data.model.SensorReading
import com.safemine.data.model.User
import com.safemine.data.repository.FakeRepository

class DeviceViewModel(private val repo: FakeRepository) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _device = MutableLiveData<Device>()
    val device: LiveData<Device> = _device

    private val _sensors = MutableLiveData<List<SensorReading>>()
    val sensors: LiveData<List<SensorReading>> = _sensors

    init {
        _user.value = repo.getCurrentUser()
        _device.value = repo.getDevice()
        _sensors.value = repo.getSensors()
    }

    class Factory(private val repo: FakeRepository) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DeviceViewModel(repo) as T
        }
    }
}
