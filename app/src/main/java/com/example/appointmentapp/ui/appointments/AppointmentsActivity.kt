package com.example.appointmentapp.ui.appointments

import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.appointmentapp.R
import com.example.appointmentapp.data.AppDatabase
import com.example.appointmentapp.injector
import com.example.appointmentapp.model.Appointment
import com.example.appointmentapp.ui.about.AboutActivity
import com.example.appointmentapp.ui.newappointment.NewAppointmentActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_appointments.*
import java.util.concurrent.Executor
import javax.inject.Inject

class AppointmentsActivity : AppCompatActivity(), AppointmentsScreen {

    private val displayedAppointments: MutableList<Appointment> = mutableListOf()
    private var appointmentsAdapter: AppointmentsAdapter? = null

    @Inject
    lateinit var appointmentsPresenter: AppointmentsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_appointments)
        setTitle("Appointments")

        appointmentsAdapter = AppointmentsAdapter(this, appointmentsPresenter, displayedAppointments)
        appointments_rv.adapter = appointmentsAdapter

        findViewById<FloatingActionButton>(R.id.add_btn).setOnClickListener { view ->
            val intent = Intent(this, NewAppointmentActivity::class.java)
            this.startActivity(intent)
        }

        findViewById<TabLayout>(R.id.navigation_tablayout).addOnTabSelectedListener((object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.text) {
                    "About" -> navigationToAbout()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        }))
    }

    override fun onStart() {
        super.onStart()
        appointmentsPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        appointmentsPresenter.detachScreen()
    }

    override fun onResume() {
        super.onResume()
        appointmentsPresenter.refreshAppointments()
    }

    override fun showAppointments(appointmentsList: List<Appointment>?) {
        displayedAppointments.clear()
        if (appointmentsList != null) {
            displayedAppointments.addAll(appointmentsList)
        }
        appointmentsAdapter?.notifyDataSetChanged()
    }

    override fun showAppointmentDeleted(id: String?) {
        Toast.makeText(applicationContext, "Appointment with ID: " + id + " was deleted", Toast.LENGTH_LONG).show()
    }

    override fun showNetworkError(errorMsg: String) {
        Toast.makeText(applicationContext, errorMsg, Toast.LENGTH_LONG).show()
    }

    fun navigationToAbout() {
        val intent = Intent(this, AboutActivity::class.java)
        this.startActivity(intent)
    }
}