package com.safemine.data.model

enum class TicketStatus { ABIERTO, EN_PROGRESO, RESUELTO }
enum class TicketPriority { ALTA, MEDIA, BAJA }

data class Ticket(
    val id: String,           // TKT-001
    val titulo: String,       // "Dispositivo WCH-004 no sincroniza"
    val prioridad: TicketPriority,
    val estado: TicketStatus,
    val creado: String,       // "05/10/2024 10:30"
    val actualizado: String   // "Hace 2 horas"
)
