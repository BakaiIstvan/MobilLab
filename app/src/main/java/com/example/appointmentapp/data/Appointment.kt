package com.example.appointmentapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "grade")
data class Appointment(
    @PrimaryKey(autoGenerate = true) var appointmentId: Long?,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "dateAndTime") var dateAndTime: String,
    @ColumnInfo(name = "endDateAndTime") var endDateAndTime: String,
    @ColumnInfo(name = "duration") var duration: BigDecimal?,
    @ColumnInfo(name = "remarks") var remarks: String
)