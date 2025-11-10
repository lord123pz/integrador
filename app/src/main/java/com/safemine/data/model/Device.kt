package com.safemine.data.model

data class Device(
    val id: String,            // WCH-001
    val alias: String,         // Pulsera IoT / Sensor Principal A
    val ubicacion: String,     // Túnel 7 - Zona B
    val bateria: Int,          // 87
    val conectado: Boolean,
    val ultimoReporteMin: Int  // Hace 2 min
)
