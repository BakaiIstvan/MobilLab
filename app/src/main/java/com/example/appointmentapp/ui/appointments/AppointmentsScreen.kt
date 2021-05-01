package com.example.appointmentapp.ui.appointments

import com.example.appointmentapp.model.Appointment


interface AppointmentsScreen {
    fun showAppointments(appointmentsList: List<Appointment>)
    fun showNetworkError(errorMsg: String)
}
