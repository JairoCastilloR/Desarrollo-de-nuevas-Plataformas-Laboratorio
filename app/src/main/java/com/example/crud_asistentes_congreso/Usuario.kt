package com.example.crud_asistentes_congreso

data class Usuario(
    val fullName: String,
    var registrationDate: String,
    var bloodType: String,
    var phone: String,
    var email: String,
    var amountPaid: String
)