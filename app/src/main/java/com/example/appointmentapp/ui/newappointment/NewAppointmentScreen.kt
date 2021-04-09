package com.example.appointmentapp.ui.newappointment

import com.example.appointmentapp.model.Appointment

interface NewAppointmentScreen {
    fun saveAppointment()
    fun showError(errorMsg: String)
}