package com.example.appointmentapp.interactor.appointments.event

import com.example.appointmentapp.model.Appointment

data class GetAppointmentsEvent(
        var code: Int = 0,
        var appointments: List<Appointment>? = null,
        var throwable: Throwable? = null
)