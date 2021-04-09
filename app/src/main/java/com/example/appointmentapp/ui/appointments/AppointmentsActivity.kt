package com.example.appointmentapp.ui.appointments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appointmentapp.R
import com.example.appointmentapp.model.Appointment
import hu.bme.aut.weatherdemo.ui.weather.AppointmentPresenter

class AppointmentsActivity : AppCompatActivity(), AppointmentsScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        AppointmentsPresenter.attachScreen(this)
    }

    override fun onStop() {
        AppointmentsPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun showAppointments(citiesList: List<Appointment>) {
        TODO("Not yet implemented")
    }
}