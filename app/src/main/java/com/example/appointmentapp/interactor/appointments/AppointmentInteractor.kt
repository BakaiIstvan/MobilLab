package com.example.appointmentapp.interactor.appointments

import android.util.Log
import com.example.appointmentapp.data.AppointmentDAO
import com.example.appointmentapp.interactor.appointments.event.GetAppointmentEvent
import com.example.appointmentapp.model.Token
import com.example.appointmentapp.network.AppointmentsAPI
import com.example.appointmentapp.network.NetworkConfig
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class AppointmentInteractor @Inject constructor(private var appointmentsApi: AppointmentsAPI, private var appointmentDao : AppointmentDAO) {
    fun getAppointment(id: String) {
        val event = GetAppointmentEvent()
        val appointment = appointmentDao.getSpecificAppointment(id)

        if (appointment != null) {
            event.code = 200
            event.appointment = appointment
            EventBus.getDefault().post(event)
        } else {
            val token = getAuthorizationToken()


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
    }

    fun getAuthorizationToken(): String {
        val tokenQueryCall = appointmentsApi.postAuthGoogle(Token(NetworkConfig.ACCESS_TOKEN))
        val response = tokenQueryCall.execute()

        return "Bearer " + response.body()?.token
    }
}