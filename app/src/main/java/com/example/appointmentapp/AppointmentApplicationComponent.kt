package com.example.appointmentapp

import com.example.appointmentapp.interactor.InteractorModule
import com.example.appointmentapp.network.NetworkModule
import com.example.appointmentapp.ui.UIModule
import com.example.appointmentapp.ui.about.AboutActivity
import com.example.appointmentapp.ui.appointment.AppointmentDetailsActivity
import com.example.appointmentapp.ui.appointments.AppointmentsActivity
import com.example.appointmentapp.ui.newappointment.NewAppointmentActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface AppointmentApplicationComponent {
    fun inject(appointmentsActivity: AppointmentsActivity)
    fun inject(appointmentDetailsActivity: AppointmentDetailsActivity)
    fun inject(newAppointmentActivity: NewAppointmentActivity)
    fun inject(aboutActivity: AboutActivity)
}
