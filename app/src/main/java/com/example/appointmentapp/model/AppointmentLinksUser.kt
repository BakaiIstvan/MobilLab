package com.example.appointmentapp.model

import com.google.gson.annotations.SerializedName

data class AppointmentLinksUser (
    @SerializedName("href")
    var href: String? = null,

    @SerializedName("title")
    var title: String? = null
)