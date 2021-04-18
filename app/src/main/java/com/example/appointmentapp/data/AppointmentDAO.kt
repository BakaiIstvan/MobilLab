package com.example.appointmentapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AppointmentDAO {
    @Query("SELECT * FROM appointment")
    fun getAppointments(): List<Appointment>

    @Query("SELECT * FROM appointment WHERE appointment = :id")
    fun getSpecificAppoitnemnt(id: String): Appointment

    @Insert
    fun insertAppointment(vararg appointment: Appointment)

    @Delete
    fun deleteSpecificAppointment(appointment: Appointment)

    @Update
    fun updateSpecificAppointment(vararg appointment: Appointment)
}