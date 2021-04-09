package com.example.appointmentapp.ui

import android.content.Context
import com.example.appointmentapp.interactor.appointments.AppointmentsInteractor
import com.example.appointmentapp.ui.appointments.AppointmentsPresenter
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
    fun mainPresenter() = AppointmentsPresenter()

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}
