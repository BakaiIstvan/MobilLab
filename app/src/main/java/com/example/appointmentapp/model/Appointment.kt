package com.example.appointmentapp.model

import java.util.*

data class Appointment(
        var title: String? = null,
        var description: String? = null,
        var start: Date? = null
)
