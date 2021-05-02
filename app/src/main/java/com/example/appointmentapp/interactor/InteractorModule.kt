package com.example.appointmentapp.interactor

import com.example.appointmentapp.data.AppDatabase
import com.example.appointmentapp.data.AppointmentDAO
import com.example.appointmentapp.interactor.appointments.AppointmentInteractor
import com.example.appointmentapp.interactor.appointments.AppointmentsInteractor
import com.example.appointmentapp.interactor.appointments.NewAppointmentInteractor
import com.example.appointmentapp.network.AppointmentsAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideAppointmentsInteractor(appointmentsApi: AppointmentsAPI, appointmentDao: AppointmentDAO) = AppointmentsInteractor(appointmentsApi, appointmentDao)

    @Provides
    @Singleton
    fun provideAppointmentInteractor(appointmentsApi: AppointmentsAPI, appointmentDao: AppointmentDAO) = AppointmentInteractor(appointmentsApi, appointmentDao)

    @Provides
    @Singleton
    fun provideNewAppointmentInteractor(appointmentsApi: AppointmentsAPI, appointmentDao: AppointmentDAO) = NewAppointmentInteractor(appointmentsApi, appointmentDao)
}
