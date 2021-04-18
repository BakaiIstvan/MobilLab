package com.example.appointmentapp.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Appointment (
    @SerializedName("_links")
    var links: AppointmentLinks? = null,

    @SerializedName("id")
    var id: String? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("dateAndTime")
    var dateAndTime: String? = null,

    @SerializedName("endDateAndTime")
    var endDateAndTime: String? = null,

    @SerializedName("duration")
    var duration: BigDecimal? = null,

    @SerializedName("remarks")
    var remarks: String? = null
)