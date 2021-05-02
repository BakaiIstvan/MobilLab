package com.example.appointmentapp

import android.content.Context
import com.example.appointmentapp.interactor.appointments.AppointmentInteractor
import com.example.appointmentapp.interactor.appointments.AppointmentsInteractor
import com.example.appointmentapp.interactor.appointments.NewAppointmentInteractor
import com.example.appointmentapp.ui.appointment.AppointmentPresenter
import com.example.appointmentapp.ui.appointments.AppointmentsPresenter
import com.example.appointmentapp.ui.newappointment.NewAppointmentPresenter
import com.example.appointmentapp.utils.UiExecutor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideNewAppointmentPresenter(executor: Executor, newAppointmentInteractor: NewAppointmentInteractor) = NewAppointmentPresenter(executor, newAppointmentInteractor)

    @Provides
    @Singleton
    fun provideAppointmentsPresenter(executor: Executor, appointmentsInteractor: AppointmentsInteractor) = AppointmentsPresenter(executor, appointmentsInteractor)

    @Provides
    @Singleton
    fun provideAppointmentPresenter(executor: Executor, appointmentInteractor: AppointmentInteractor) = AppointmentPresenter(executor, appointmentInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()
}