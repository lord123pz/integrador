package com.safemine.data.model

data class SensorReading(
    val nombre: String,      // H2S (Sulfuro de Hidrógeno)
    val unidad: String,      // ppm / µg/m³ / %
    val valorActual: Double,
    val limiteSeguro: Double,
    val estado: String       // "Seguro", "Advertencia", "Crítico"
)
