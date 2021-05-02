package com.example.appointmentapp.ui.appointment

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appointmentapp.R
import com.example.appointmentapp.injector
import com.example.appointmentapp.model.Appointment
import com.example.appointmentapp.ui.about.AboutActivity
import com.example.appointmentapp.ui.appointments.AppointmentsActivity
import com.example.appointmentapp.ui.appointments.AppointmentsAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_appointment.*
import javax.inject.Inject

class AppointmentDetailsActivity : AppCompatActivity(), AppointmentScreen {

    private var displayedAppointment: Appointment? = Appointment()

    @Inject
    lateinit var appointmentPresenter: AppointmentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
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
        appointmentPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        appointmentPresenter.detachScreen()
    }

    override fun onResume() {
        super.onResume()
        appointmentPresenter.refreshAppointment(intent.getStringExtra(AppointmentsAdapter.APPOINTMENT_ID))
    }

    override fun showAppointmentDetails(appointment: Appointment) {
        displayedAppointment = appointment
        setTitle(displayedAppointment!!.title)
        start_card_value.text = displayedAppointment!!.dateAndTime
        end_card_value.text = displayedAppointment!!.endDateAndTime
        duration_card_value.text = displayedAppointment!!.duration.toString()
        description_card_value.text = displayedAppointment!!.remarks
    }

    override fun showError(errorMsg: String) {
        Toast.makeText(applicationContext, errorMsg, Toast.LENGTH_LONG).show()
    }

    fun navigationToAbout() {
        val intent = Intent(this, AboutActivity::class.java)
        this.startActivity(intent)
    }

    fun navigationToAppointments() {
        val intent = Intent(this, AppointmentsActivity::class.java)
        this.startActivity(intent)
    }
}