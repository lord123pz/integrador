package com.safemine.data.model

/**
 * Represents a SafeMine user that can monitor devices and respond to alerts.
 */
data class User(
    val id: String,
    val name: String,
    val email: String,
    val role: Role,
    val assignedDevices: List<Device> = emptyList()
)
