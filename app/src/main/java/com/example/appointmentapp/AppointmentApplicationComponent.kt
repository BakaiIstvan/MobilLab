package com.example.appointmentapp

import com.example.appointmentapp.interactor.InteractorModule
import com.example.appointmentapp.ui.UIModule
import com.example.appointmentapp.ui.appointments.AppointmentsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, InteractorModule::class])
interface AppointmentApplicationComponent {
    fun inject(appointmentsActivity: AppointmentsActivity)
}
