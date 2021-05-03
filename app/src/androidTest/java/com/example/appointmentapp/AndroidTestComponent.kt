package com.example.appointmentapp

import com.example.appointmentapp.interactor.InteractorModule
import com.example.appointmentapp.mock.MockDatabaseModule
import com.example.appointmentapp.mock.MockNetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, MockDatabaseModule::class, AndroidTestModule::class, InteractorModule::class])
interface AndroidTestComponent : AppointmentApplicationComponent