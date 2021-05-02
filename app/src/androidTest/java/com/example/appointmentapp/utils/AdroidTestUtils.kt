package com.example.appointmentapp.utils

import androidx.test.platform.app.InstrumentationRegistry
import com.example.appointmentapp.AndroidTestModule
import com.example.appointmentapp.AppointmentApplication
import com.example.appointmentapp.DaggerAndroidTestComponent
import com.example.appointmentapp.DaggerAppointmentApplicationComponent
import com.example.appointmentapp.ui.UIModule

object AndroidTestUtils {

    fun setTestInjector() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as AppointmentApplication

        val androidTestComponent = DaggerAndroidTestComponent.builder().androidTestModule(
            AndroidTestModule(app)
        ).build()
        app.injector = androidTestComponent
    }

    fun setProdutionInjector() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as AppointmentApplication

        val androidTestComponent = DaggerAppointmentApplicationComponent.builder().uIModule(UIModule(app)).build()
        app.injector = androidTestComponent
    }
}