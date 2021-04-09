package com.example.appointmentapp.ui.newappointment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appointmentapp.R
import com.example.appointmentapp.model.Appointment

class NewAppointmentActivity : AppCompatActivity(), NewAppointmentScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        NewAppointmentPresenter.attachScreen(this)
    }

    override fun onStop() {
        NewAppointmentPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun saveAppointment() {}

    override fun showError(errorMsg: String) {}
}