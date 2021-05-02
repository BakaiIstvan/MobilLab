package com.example.appointmentapp.ui.appointment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appointmentapp.R
import com.example.appointmentapp.model.Appointment
import com.example.appointmentapp.ui.about.AboutActivity
import com.example.appointmentapp.ui.appointments.AppointmentsActivity
import com.google.android.material.tabs.TabLayout

class AppointmentDetailsActivity : AppCompatActivity(), AppointmentScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)
        setTitle("Appointment")

        findViewById<TabLayout>(R.id.navigation_tablayout).addOnTabSelectedListener((object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.text) {
                    "About" -> navigationToAbout()
                    "Appointments" -> navigationToAppointments()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                when (tab.text) {
                    "About" -> navigationToAbout()
                    "Appointments" -> navigationToAppointments()
                }
            }
        }))
    }

    override fun onStart() {
        super.onStart()
        AppointmentPresenter.attachScreen(this)
    }

    override fun onStop() {
        AppointmentPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun showAppointmentDetails(appointment: Appointment) {}

    override fun showError(errorMsg: String) {}

    fun navigationToAbout() {
        val intent = Intent(this, AboutActivity::class.java)
        this.startActivity(intent)
    }

    fun navigationToAppointments() {
        val intent = Intent(this, AppointmentsActivity::class.java)
        this.startActivity(intent)
    }
}