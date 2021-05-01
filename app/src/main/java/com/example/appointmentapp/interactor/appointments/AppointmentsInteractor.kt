package com.example.appointmentapp.interactor.appointments

import android.util.Log
import com.example.appointmentapp.interactor.appointments.event.DeleteAppointmentEvent
import com.example.appointmentapp.interactor.appointments.event.GetAppointmentEvent
import com.example.appointmentapp.interactor.appointments.event.GetAppointmentsEvent
import com.example.appointmentapp.model.Token
import com.example.appointmentapp.network.AppointmentsAPI
import com.example.appointmentapp.network.NetworkConfig
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class AppointmentsInteractor @Inject constructor(private var appointmentsApi: AppointmentsAPI) {
    fun getAppointments() {
        val token = getAuthorizationToken()
        val event = GetAppointmentsEvent()

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
            }
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }

    }

    fun getAppointment(id: String) {
        val token = getAuthorizationToken()
        val event = GetAppointmentEvent()

        try {
            val appointmentsQueryCall = appointmentsApi.getAppointmentsId(token, id)

            val response = appointmentsQueryCall?.execute()
            if (response != null) {
                Log.d("Reponse", response.body().toString())

                if (response.code() != 200) {
                    throw Exception("Result code is not 200")
                }

                event.code = response.code()
                event.appointment = response.body()
            }
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun deleteAppointment(id: String) {
        val token = getAuthorizationToken()
        val event = DeleteAppointmentEvent()

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
        return "Bearer " + tokenQueryCall.execute().body()?.token
    }
}
