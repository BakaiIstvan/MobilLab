package com.example.appointmentapp.interactor.appointments.event

import com.example.appointmentapp.model.Appointment

data class GetAppointmentEvent(
    var code: Int = 0,
    var appointment: Appointment? = null,
    var throwable: Throwable? = null
)