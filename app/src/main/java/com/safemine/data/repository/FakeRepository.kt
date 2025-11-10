package com.safemine.data.repository

import com.safemine.data.model.Alert
import com.safemine.data.model.AlertSeverity
import com.safemine.data.model.Device
import com.safemine.data.model.Role
import com.safemine.data.model.SensorReading
import com.safemine.data.model.Ticket
import com.safemine.data.model.TicketPriority
import com.safemine.data.model.TicketStatus
import com.safemine.data.model.User

class FakeRepository {

    fun getCurrentUser(): User =
        User(
            id = "OP-2847",
            nombre = "Juan",
            apellido = "Pérez García",
            email = "juan.perez@mineradelnorte.cl",
            telefono = "+56 9 1234 5678",
            cargo = "Operador de Campo",
            departamento = "Operaciones",
            rol = Role.OPERADOR
        )

    fun getDevice(): Device =
        Device(
            id = "WCH-001",
            alias = "Pulsera IoT Alpha",
            ubicacion = "Túnel 7 - Zona B",
            bateria = 87,
            conectado = true,
            ultimoReporteMin = 2
        )

    fun getSensors(): List<SensorReading> = listOf(
        SensorReading("H₂S", "ppm", 5.2, 10.0, "Seguro"),
        SensorReading("CO", "ppm", 18.0, 50.0, "Seguro"),
        SensorReading("O₂", "%", 20.8, 19.5, "Seguro"),
        SensorReading("Polvo", "µg/m³", 145.0, 120.0, "Advertencia"),
        SensorReading("Temperatura", "°C", 26.3, 35.0, "Seguro"),
        SensorReading("Humedad", "%", 48.0, 80.0, "Seguro")
    )

    fun getActiveAlerts(): List<Alert> = listOf(
        Alert(
            id = "AL-001",
            titulo = "Gas Tóxico Alto",
            mensaje = "H₂S 12.4 ppm - Límite seguro superado. Acción requerida: evacuar zona.",
            severidad = AlertSeverity.CRITICA,
            tiempo = "Hace 5 min",
            dispositivoId = "WCH-004",
            ubicacion = "Túnel 7 - Zona B",
            valorDetectado = "12.4 ppm",
            umbral = "10 ppm",
            estado = "Pendiente"
        ),
        Alert(
            id = "AL-002",
            titulo = "Polvo Elevado",
            mensaje = "Concentración de polvo por encima del nivel recomendado.",
            severidad = AlertSeverity.ALTA,
            tiempo = "Hace 12 min",
            dispositivoId = "WCH-002",
            ubicacion = "Túnel 7 - Zona A",
            valorDetectado = "145 µg/m³",
            umbral = "120 µg/m³",
            estado = "En aumento"
        )
    )

    fun getAlertsHistory(): List<Alert> =
        getActiveAlerts() + listOf(
            Alert(
                id = "AL-003",
                titulo = "CO en Aumento",
                mensaje = "Nivel de CO mostrando tendencia al alza.",
                severidad = AlertSeverity.MEDIA,
                tiempo = "Hace 32 min",
                dispositivoId = "WCH-003",
                ubicacion = "Zona Central",
                valorDetectado = "35 ppm",
                umbral = "38 ppm",
                estado = "Resuelta"
            )
        )

    fun getTickets(): List<Ticket> = listOf(
        Ticket("TKT-001", "Dispositivo WCH-004 no sincroniza",
            TicketPriority.ALTA, TicketStatus.ABIERTO,
            "05/10/2024 10:30", "Hace 2 horas"),
        Ticket("TKT-002", "Consulta sobre actualización de plan",
            TicketPriority.MEDIA, TicketStatus.EN_PROGRESO,
            "03/10/2024 14:20", "Hace 1 día"),
        Ticket("TKT-003", "Solicitud de factura adicional",
            TicketPriority.BAJA, TicketStatus.RESUELTO,
            "01/10/2024 09:15", "Hace 3 días")
    )
}
