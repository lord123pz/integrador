package com.safemine.data.model

enum class AlertSeverity { CRITICA, ALTA, MEDIA, BAJA }

data class Alert(
    val id: String,
    val titulo: String,       // "Nivel H2S Crítico"
    val mensaje: String,      // "El nivel de H2S superó el límite seguro..."
    val severidad: AlertSeverity,
    val tiempo: String,       // "Hace 5 min"
    val dispositivoId: String,
    val ubicacion: String,    // "Túnel 7 - Zona B"
    val valorDetectado: String,
    val umbral: String,
    val estado: String        // "Pendiente" / "Resuelta"
)
