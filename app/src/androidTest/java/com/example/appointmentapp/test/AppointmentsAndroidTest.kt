package com.example.appointmentapp.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.appointmentapp.ui.appointments.AppointmentsActivity
import com.example.appointmentapp.utils.EspressoTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class AppointmentsAndroidTest : EspressoTest<AppointmentsActivity>(AppointmentsActivity::class.java) {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.appointmentapp", appContext.packageName)
    }
}