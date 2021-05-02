package com.example.appointmentapp.test

import com.example.appointmentapp.model.Appointment
import com.example.appointmentapp.testInjector
import com.example.appointmentapp.ui.appointments.AppointmentsPresenter
import com.example.appointmentapp.ui.appointments.AppointmentsScreen
import com.example.appointmentapp.utils.argumentCaptor
import com.example.appointmentapp.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class AppointmentsTest {
    @Inject
    lateinit var appointmentsPresenter: AppointmentsPresenter

    private lateinit var appointmentsScreen: AppointmentsScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        appointmentsScreen = mock()
        appointmentsPresenter.attachScreen(appointmentsScreen)
    }

    @Test
    fun testGetAppointments() {
        appointmentsPresenter.refreshAppointments()

        val list = argumentCaptor<MutableList<Appointment>>()
        verify(appointmentsScreen).showAppointments(list.capture())
        assert(list.value.size > 0)
    }

    @After
    fun tearDown() {
        appointmentsPresenter.detachScreen()
    }
}