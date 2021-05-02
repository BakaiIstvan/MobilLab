package com.example.appointmentapp.data

import androidx.room.*
import com.example.appointmentapp.model.Appointment

@Dao
interface AppointmentDAO {
    @Query("SELECT * FROM appointment")
    fun getAppointments(): List<Appointment>

    @Query("SELECT * FROM appointment WHERE id = :id")
    fun getSpecificAppointment(id: String): Appointment

    @Insert
    fun insertAppointment(vararg appointment: Appointment)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAppointments(appointments: List<Appointment>)

    @Delete
    fun deleteSpecificAppointment(appointment: Appointment)

    @Update
    fun updateSpecificAppointment(vararg appointment: Appointment)
}