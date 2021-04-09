package com.example.appointmentapp

import android.app.Application
import com.example.appointmentapp.ui.UIModule

class AppointmentApplication : Application() {
    lateinit var injector: AppointmentApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerAppointmentApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}
