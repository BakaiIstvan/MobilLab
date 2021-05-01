package com.example.appointmentapp.ui.appointments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appointmentapp.R
import com.example.appointmentapp.model.Appointment
import kotlinx.android.synthetic.main.appointment_card.view.*

class AppointmentsAdapter constructor(
        private val context: Context,
        private var appointments: List<Appointment>) : RecyclerView.Adapter<AppointmentsAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var itemTitle: TextView = view.appointment_title
        var itemStart: TextView = view.appointment_start
        var itemEnd: TextView = view.appointment_end
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.appointment_card, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount() = appointments.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val appointment = appointments[position]

        holder.itemTitle.text = appointment.title
        holder.itemStart.text = appointment.dateAndTime
        holder.itemEnd.text = appointment.endDateAndTime
    }
}