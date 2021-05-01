package com.example.appointmentapp.ui.newappointment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appointmentapp.R
import com.example.appointmentapp.model.Appointment
import com.example.appointmentapp.ui.appointments.AppointmentsActivity

class NewAppointmentActivity : AppCompatActivity(), NewAppointmentScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newappointment)
        setTitle("New appointment")

        findViewById<Button>(R.id.cancel_button).setOnClickListener { view ->
            val intent = Intent(this, AppointmentsActivity::class.java)
            this.startActivity(intent)
        }
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