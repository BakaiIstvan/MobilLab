package com.example.appointmentapp.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

@Entity(tableName = "appointment")
data class Appointment (
    @SerializedName("links")
    @Ignore
    var links: AppointmentLinks? = null,

    @SerializedName("id")
    @PrimaryKey
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