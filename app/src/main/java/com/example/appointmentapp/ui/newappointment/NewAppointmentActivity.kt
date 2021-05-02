package com.example.appointmentapp.ui.newappointment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appointmentapp.R
import com.example.appointmentapp.injector
import com.example.appointmentapp.model.Appointment
import com.example.appointmentapp.model.AppointmentBody
import com.example.appointmentapp.ui.appointments.AppointmentsActivity
import com.example.appointmentapp.ui.appointments.AppointmentsAdapter
import com.example.appointmentapp.ui.appointments.AppointmentsPresenter
import kotlinx.android.synthetic.main.activity_newappointment.*
import javax.inject.Inject

class NewAppointmentActivity : AppCompatActivity(), NewAppointmentScreen {

    private var newAppointment: Appointment? = null

    @Inject
    lateinit var newAppointmentPresenter:  NewAppointmentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_newappointment)
        setTitle("New appointment")

        cancel_button.setOnClickListener { view ->
            val intent = Intent(this, AppointmentsActivity::class.java)
            this.startActivity(intent)
        }

        done_button.setOnClickListener { view ->
            val appointmentBody: AppointmentBody = AppointmentBody(edit_title_card.text.toString(),
                                                                   edit_start_card.text.toString(),
                                                                   edit_end_card.text.toString(),
                                                                   edit_duration_card.text.toString().toBigDecimal(),
                                                                   edit_description_card.text.toString())

            if (newAppointment != null) {
                newAppointmentPresenter.modifyAppointment(newAppointment!!.id, appointmentBody)
            } else {
                newAppointmentPresenter.saveAppointment(appointmentBody)
            }

            val intent = Intent(this, AppointmentsActivity::class.java)
            this.startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        newAppointmentPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        newAppointmentPresenter.detachScreen()
    }

    override fun onResume() {
        super.onResume()
        val id = intent.getStringExtra(AppointmentsAdapter.APPOINTMENT_ID)
        newAppointmentPresenter.loadAppointment(id)
    }

    override fun loadAppointment(appointment: Appointment) {
        edit_title_card.setText(appointment.title)
        edit_start_card.setText(appointment.dateAndTime)
        edit_end_card.setText(appointment.endDateAndTime)
        edit_duration_card.setText(appointment.duration.toString())
        edit_description_card.setText(appointment.remarks)
        newAppointment = appointment
    }

    override fun showAppointmentSaved(id: String) {
        Toast.makeText(applicationContext, "Appointment with ID: " + id + " was saved", Toast.LENGTH_LONG).show()
    }

    override fun showAppointmentModified(id: String) {
        Toast.makeText(applicationContext, "Appointment with ID: " + id + " was modified", Toast.LENGTH_LONG).show()
    }

    override fun showError(errorMsg: String) {
        Toast.makeText(applicationContext, errorMsg, Toast.LENGTH_LONG).show()
    }
}