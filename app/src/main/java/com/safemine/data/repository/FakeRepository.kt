package com.safemine.data.repository

import com.safemine.data.model.Alert
import com.safemine.data.model.Device
import com.safemine.data.model.DeviceStatus
import com.safemine.data.model.Role
import com.safemine.data.model.SensorReading
import com.safemine.data.model.Severity
import com.safemine.data.model.Ticket
import com.safemine.data.model.TicketStatus
import com.safemine.data.model.User
import java.time.Instant

/**
 * Temporary in-memory repository used to prototype the SafeMine flows.
 */
class FakeRepository {

    private val devices = listOf(
        Device(
            id = "device-1",
            name = "Atmospheric Monitor",
            status = DeviceStatus.ONLINE,
            lastHeartbeat = Instant.now(),
            batteryLevel = 92
        ),
        Device(
            id = "device-2",
            name = "Structural Sensor",
            status = DeviceStatus.MAINTENANCE,
            lastHeartbeat = Instant.now().minusSeconds(3_600),
            batteryLevel = 47
        )
    )

    private val users = listOf(
        User(
            id = "user-1",
            name = "Laura Supervisor",
            email = "laura@safemine.com",
            role = Role.SUPERVISOR,
            assignedDevices = devices
        ),
        User(
            id = "user-2",
            name = "Carlos Operador",
            email = "carlos@safemine.com",
            role = Role.OPERATOR,
            assignedDevices = listOf(devices.first())
        )
    )

    private val alerts = listOf(
        Alert(
            id = "alert-1",
            deviceId = devices.first().id,
            severity = Severity.HIGH,
            message = "Gas concentration exceeded threshold",
            acknowledged = false,
            generatedAt = Instant.now().minusSeconds(600)
        )
    )

    private val tickets = listOf(
        Ticket(
            id = "ticket-1",
            title = "Inspect ventilation",
            description = "Check ventilation in north tunnel",
            status = TicketStatus.IN_PROGRESS,
            createdAt = Instant.now().minusSeconds(43_200),
            updatedAt = Instant.now().minusSeconds(1_800),
            assignedTo = users.first()
        )
    )

    private val readings = listOf(
        SensorReading(
            id = "reading-1",
            deviceId = devices.first().id,
            type = "CO2",
            value = 41.5,
            recordedAt = Instant.now().minusSeconds(120)
        )
    )

    fun getUsers(): List<User> = users

    fun getDevices(): List<Device> = devices

    fun getAlerts(): List<Alert> = alerts

    fun getTickets(): List<Ticket> = tickets

    fun getLatestReadings(): List<SensorReading> = readings
}
