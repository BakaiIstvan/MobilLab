package com.example.appointmentapp.interactor.appointments.event

import com.example.appointmentapp.model.Appointment

data class DeleteAppointmentEvent (
    var code: Int = 0,
    var id: String? = null,
    var throwable: Throwable? = null
)