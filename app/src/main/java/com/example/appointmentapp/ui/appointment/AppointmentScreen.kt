package hu.bme.aut.weatherdemo.ui.weather

import com.example.appointmentapp.model.Appointment

interface AppointmentScreen {
    fun showAppointmentDetails(appointment: Appointment)
    fun showError(errorMsg: String)
}