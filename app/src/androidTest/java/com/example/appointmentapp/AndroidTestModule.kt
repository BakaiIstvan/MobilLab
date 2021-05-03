package com.example.appointmentapp

import android.content.Context
import com.example.appointmentapp.interactor.appointments.AppointmentInteractor
import com.example.appointmentapp.interactor.appointments.AppointmentsInteractor
import com.example.appointmentapp.interactor.appointments.NewAppointmentInteractor
import com.example.appointmentapp.ui.UIModule
import com.example.appointmentapp.ui.appointment.AppointmentPresenter
import com.example.appointmentapp.ui.appointments.AppointmentsPresenter
import com.example.appointmentapp.ui.newappointment.NewAppointmentPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class AndroidTestModule(context: Context) {

    private val uiModule: UIModule = UIModule(context)

    @Provides
    fun provideContext(): Context {
        return uiModule.context()
    }

    @Provides
    @Singleton
    fun provideAppointmentsPresenter(executor: Executor, appointmentsInteractor: AppointmentsInteractor): AppointmentsPresenter {
        return uiModule.appointmentsPresenter(executor, appointmentsInteractor)
    }

    @Provides
    @Singleton
    fun provideAppointmentPresenter(executor: Executor, appointmentInteractor: AppointmentInteractor): AppointmentPresenter {
        return uiModule.appointmentPresenter(executor, appointmentInteractor)
    }

    @Provides
    @Singleton
    fun provideNewAppointmentPresenter(executor: Executor, newAppointmentInteractor: NewAppointmentInteractor): NewAppointmentPresenter {
        return uiModule.newAppointmentPresenter(executor, newAppointmentInteractor)
    }

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor {
        return uiModule.networkExecutor()
    }

}