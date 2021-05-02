package com.example.appointmentapp.mock

import android.content.Context
import androidx.room.Room
import com.example.appointmentapp.data.AppDatabase
import com.example.appointmentapp.data.AppointmentDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockDatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
    }

    @Provides
    @Singleton
    fun provideAppointmentDao(db: AppDatabase): AppointmentDAO = MockAppointmentDAO()
}