package com.example.appointmentapp.ui.appointments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appointmentapp.R
import com.example.appointmentapp.model.Appointment
import hu.bme.aut.weatherdemo.ui.weather.AppointmentPresenter
import javax.inject.Inject

class AppointmentsActivity : AppCompatActivity(), AppointmentsScreen {

    @Inject
    lateinit var appointmentsPresenter: AppointmentsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)
        setTitle("Appointments")
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun showAppointments(citiesList: List<Appointment>) {
        TODO("Not yet implemented")
    }
}