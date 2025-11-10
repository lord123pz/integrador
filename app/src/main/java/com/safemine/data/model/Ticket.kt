package com.safemine.data.model

import java.time.Instant

/**
 * Represents a work ticket raised from an alert or manual user action.
 */
data class Ticket(
    val id: String,
    val title: String,
    val description: String,
    val status: TicketStatus,
    val createdAt: Instant,
    val updatedAt: Instant,
    val assignedTo: User?
)

enum class TicketStatus {
    OPEN,
    IN_PROGRESS,
    RESOLVED,
    CLOSED
}
