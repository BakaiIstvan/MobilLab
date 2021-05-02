package com.example.appointmentapp.interactor

import com.example.appointmentapp.data.AppDatabase
import com.example.appointmentapp.data.AppointmentDAO
import com.example.appointmentapp.interactor.appointments.AppointmentsInteractor
import com.example.appointmentapp.network.AppointmentsAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideAppointmentsInteractor(appointmentsApi: AppointmentsAPI, appointmentDao: AppointmentDAO) = AppointmentsInteractor(appointmentsApi, appointmentDao)
}
