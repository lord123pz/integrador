package com.safemine.data.model

data class User(
    val id: String,
    val nombre: String,
    val apellido: String,
    val email: String,
    val telefono: String,
    val cargo: String,
    val departamento: String,
    val rol: Role
)
