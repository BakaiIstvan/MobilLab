package com.example.appointmentapp.mock

import android.content.Context
import com.example.appointmentapp.data.AppDatabase
import com.example.appointmentapp.data.AppointmentDAO
import dagger.Provides
import javax.inject.Singleton

class MockDatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase = MockAppDatabase()

    @Provides
    @Singleton
    fun provideAppointmentDao(db: AppDatabase): AppointmentDAO = MockAppointmentDAO()
}