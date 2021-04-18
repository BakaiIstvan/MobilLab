package com.example.appointmentapp.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class AppointmentsEmbedded (
    @SerializedName("appointment")
    var appointment: MutableList<Appointment> =
        ArrayList()
)