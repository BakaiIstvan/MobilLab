package com.example.appointmentapp.interactor.appointments

import android.util.Log
import com.example.appointmentapp.data.AppDatabase
import com.example.appointmentapp.data.AppointmentDAO
import com.example.appointmentapp.interactor.appointments.event.DeleteAppointmentEvent
import com.example.appointmentapp.interactor.appointments.event.GetAppointmentsEvent
import com.example.appointmentapp.model.Appointment
import com.example.appointmentapp.model.Token
import com.example.appointmentapp.network.AppointmentsAPI
import com.example.appointmentapp.network.NetworkConfig
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class AppointmentsInteractor @Inject constructor(private var appointmentsApi: AppointmentsAPI, private var appointmentDao : AppointmentDAO) {
    fun getAppointments() {
        val appointments = appointmentDao.getAppointments()
        val event = GetAppointmentsEvent()

        if (!appointments.isEmpty()) {
            event.code = 200
            event.appointments = appointments
            EventBus.getDefault().post(event)
        } else {
            val token = getAuthorizationToken()

            try {
                val appointmentsQueryCall = appointmentsApi.getAppointments(token)

                val response = appointmentsQueryCall?.execute()
                if (response != null) {
                    Log.d("Reponse", response.body().toString())

                    if (response.code() != 200) {
                        throw Exception("Result code is not 200")
                    }

                    event.code = response.code()
                    event.appointments = response.body()?.embedded?.appointment
                    if (event.appointments != null) {
                        appointmentDao.insertAppointments(event.appointments as MutableList<Appointment>)
                    }
                }
                EventBus.getDefault().post(event)
            } catch (e: Exception) {
                event.throwable = e
                EventBus.getDefault().post(event)
            }
        }
    }

    fun deleteAppointment(id: String) {
        val token = getAuthorizationToken()
        val event = DeleteAppointmentEvent()

        val appointment = appointmentDao.getSpecificAppointment(id)
        appointmentDao.deleteSpecificAppointment(appointment)

        try {
            val appointmentsQueryCall = appointmentsApi.deleteAppointmentsId(token, id)

            val response = appointmentsQueryCall?.execute()
            if (response != null) {
                Log.d("Reponse", response.body().toString())

                if (response.code() != 200) {
                    throw Exception("Result code is not 200")
                }

                event.code = response.code()
                event.id = id
            }
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun getAuthorizationToken(): String {
        val tokenQueryCall = appointmentsApi.postAuthGoogle(Token(NetworkConfig.ACCESS_TOKEN))
        val response = tokenQueryCall.execute()

        return "Bearer " + response.body()?.token
    }
}
