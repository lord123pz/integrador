package com.safemine.data.model

import java.time.Instant

/**
 * Captures real-time measurements emitted by a device sensor.
 */
data class SensorReading(
    val id: String,
    val deviceId: String,
    val type: String,
    val value: Double,
    val recordedAt: Instant
)
