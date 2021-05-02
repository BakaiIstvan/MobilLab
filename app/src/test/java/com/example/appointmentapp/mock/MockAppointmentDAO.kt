package com.example.appointmentapp.mock

import com.example.appointmentapp.data.AppointmentDAO
import com.example.appointmentapp.model.Appointment
import java.math.BigDecimal

class MockAppointmentDAO : AppointmentDAO {
    override fun getAppointments(): List<Appointment> {
        return listOf(Appointment(null
                                , "id1"
                                , "Appointment1"
                                , "2021-06-01T14:45:00.000Z"
                                , "2021-06-01T14:45:00.000Z"
                                , BigDecimal(30)
                                , "Same as last time"))
    }

    override fun getSpecificAppointment(id: String): Appointment {
        return Appointment(null
                         , id
                         , "Appointment1"
                         , "2021-06-01T14:45:00.000Z"
                         , "2021-06-01T14:45:00.000Z"
                         , BigDecimal(30)
                         , "Same as last time")
    }

    override fun insertAppointment(vararg appointment: Appointment) {
        TODO("Not yet implemented")
    }

    override fun insertAppointments(appointments: List<Appointment>) {
        TODO("Not yet implemented")
    }

    override fun deleteSpecificAppointment(appointment: Appointment) {
        TODO("Not yet implemented")
    }

    override fun updateSpecificAppointment(vararg appointment: Appointment) {
        TODO("Not yet implemented")
    }
}