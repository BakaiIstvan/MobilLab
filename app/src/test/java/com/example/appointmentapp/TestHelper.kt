package com.example.appointmentapp

import androidx.test.core.app.ApplicationProvider
import org.robolectric.shadows.ShadowLog

val testInjector: TestComponent
    get() {
        ShadowLog.stream = System.out
        val application = ApplicationProvider.getApplicationContext() as AppointmentApplication
        val component = DaggerTestComponent.builder().testModule(TestModule(application.applicationContext)).build()
        application.injector = component
        return component
    }