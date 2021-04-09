package com.example.appointmentapp.interactor.appointments

import com.example.appointmentapp.network.AppointmentsAPI
import javax.inject.Inject

class AppointmentsInteractor @Inject constructor(private var appointmentsApi: AppointmentsAPI) {
    fun getAppointments() {}
}
