package com.safemine.data.model

import java.time.Instant

/**
 * Represents a safety device installed in the mine.
 */
data class Device(
    val id: String,
    val name: String,
    val status: DeviceStatus,
    val lastHeartbeat: Instant,
    val batteryLevel: Int
)

enum class DeviceStatus {
    ONLINE,
    OFFLINE,
    MAINTENANCE
}
