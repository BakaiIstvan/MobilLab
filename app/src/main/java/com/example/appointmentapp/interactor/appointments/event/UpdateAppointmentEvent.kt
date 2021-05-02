package com.example.appointmentapp.interactor.appointments.event

data class UpdateAppointmentEvent (
    var code: Int = 0,
    var id: String? = null,
    var throwable: Throwable? = null
)