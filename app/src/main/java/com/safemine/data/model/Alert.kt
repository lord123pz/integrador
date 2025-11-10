package com.safemine.data.model

import java.time.Instant

/**
 * Represents a high level notification produced by the monitoring platform.
 */
data class Alert(
    val id: String,
    val deviceId: String,
    val severity: Severity,
    val message: String,
    val acknowledged: Boolean,
    val generatedAt: Instant
)

enum class Severity {
    LOW,
    MEDIUM,
    HIGH,
    CRITICAL
}
