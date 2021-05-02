package com.example.appointmentapp.model

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

@Entity(tableName = "appointment")
data class Appointment (
    @SerializedName("links")
    @Nullable
    var links: AppointmentLinks? = null,

    @SerializedName("id")
    @PrimaryKey
    var id: String,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("dateAndTime")
    @ColumnInfo(name = "dateandtime")
    var dateAndTime: String? = null,

    @SerializedName("endDateAndTime")
    @ColumnInfo(name = "enddateandtime")
    var endDateAndTime: String? = null,

    @SerializedName("duration")
    var duration: BigDecimal? = null,

    @SerializedName("remarks")
    var remarks: String? = null
)