package com.example.appointmentapp.mock

import com.example.appointmentapp.data.AppDatabase
import dagger.Provides
import javax.inject.Singleton

class MockDatabaseModule {
    @Provides
    @Singleton
    fun provideAppointmentsDb(): AppDatabase = MockAppDatabase()
}