package com.example.appointmentapp.ui.newappointment

import com.example.appointmentapp.model.Appointment

interface NewAppointmentScreen {
    fun loadAppointment(appointment: Appointment)
    fun showAppointmentSaved(id: String)
    fun showAppointmentModified(id: String)
    fun showError(errorMsg: String)
}