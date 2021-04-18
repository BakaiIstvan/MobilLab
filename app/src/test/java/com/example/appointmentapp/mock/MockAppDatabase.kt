package com.example.appointmentapp.mock

import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.appointmentapp.data.AppDatabase
import com.example.appointmentapp.data.AppointmentDAO

class MockAppDatabase : AppDatabase() {
    override fun appointmentDao(): AppointmentDAO {
        return MockAppointmentDAO()
    }

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }


}