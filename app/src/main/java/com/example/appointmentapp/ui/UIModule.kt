package com.example.appointmentapp.ui

import android.content.Context
import com.example.appointmentapp.interactor.appointments.AppointmentInteractor
import com.example.appointmentapp.interactor.appointments.AppointmentsInteractor
import com.example.appointmentapp.interactor.appointments.NewAppointmentInteractor
import com.example.appointmentapp.ui.appointment.AppointmentPresenter
import com.example.appointmentapp.ui.appointments.AppointmentsPresenter
import com.example.appointmentapp.ui.newappointment.NewAppointmentPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun appointmentsPresenter(executor: Executor, appointmentsInteractor: AppointmentsInteractor) = AppointmentsPresenter(executor, appointmentsInteractor)

    @Provides
    @Singleton
    fun appointmentPresenter(executor: Executor, appointmentInteractor: AppointmentInteractor) = AppointmentPresenter(executor, appointmentInteractor)

    @Provides
    @Singleton
    fun newAppointmentPresenter(executor: Executor, newAppointmentInteractor: NewAppointmentInteractor) = NewAppointmentPresenter(executor, newAppointmentInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}
