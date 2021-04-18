package com.example.appointmentapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appointmentapp.model.Appointment

@Database(entities = [Appointment::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appointmentDao(): AppointmentDAO
}

