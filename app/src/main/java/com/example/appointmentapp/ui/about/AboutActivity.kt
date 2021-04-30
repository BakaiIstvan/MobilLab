package com.example.appointmentapp.ui.about

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appointmentapp.R
import com.example.appointmentapp.ui.appointments.AppointmentsActivity
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity(), AboutScreen{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        findViewById<TabLayout>(R.id.navigation_tablayout).addOnTabSelectedListener((object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.text) {
                    "Appointments" -> navigationToAppointments()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                when (tab.text) {
                    "Appointments" -> navigationToAppointments()
                }
            }
        }))
    }

    fun navigationToAppointments() {
        val intent = Intent(this, AppointmentsActivity::class.java)
        this.startActivity(intent)
    }
}