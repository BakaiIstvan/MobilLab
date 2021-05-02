package com.example.appointmentapp

import com.example.appointmentapp.interactor.InteractorModule
import com.example.appointmentapp.mock.MockDatabaseModule
import com.example.appointmentapp.mock.MockNetworkModule
import com.example.appointmentapp.test.AppointmentDetailsTest
import com.example.appointmentapp.test.AppointmentsTest
import com.example.appointmentapp.test.NewAppointmentTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class, MockDatabaseModule::class])
interface TestComponent : AppointmentApplicationComponent {
    fun inject(appointmentsTest: AppointmentsTest)
    fun inject(appointmentDetailsTest: AppointmentDetailsTest)
    fun inject(newAppointmentTest: NewAppointmentTest)
}