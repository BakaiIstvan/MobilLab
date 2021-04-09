package com.example.appointmentapp.ui.appointments

import com.example.appointmentapp.ui.Presenter

object AppointmentsPresenter : Presenter<AppointmentsScreen?>() {
    override fun attachScreen(screen: AppointmentsScreen?) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun queryAppointments() {}
}
