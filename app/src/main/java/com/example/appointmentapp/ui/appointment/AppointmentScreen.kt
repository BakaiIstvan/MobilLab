package com.example.appointmentapp.ui.appointment

import com.example.appointmentapp.model.Appointment

interface AppointmentScreen {
    fun showAppointmentDetails(appointment: Appointment?)
    fun showError(errorMsg: String)
}