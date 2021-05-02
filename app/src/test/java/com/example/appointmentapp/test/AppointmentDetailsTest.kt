package com.example.appointmentapp.test

import com.example.appointmentapp.model.Appointment
import com.example.appointmentapp.testInjector
import com.example.appointmentapp.ui.appointment.AppointmentPresenter
import com.example.appointmentapp.ui.appointment.AppointmentScreen
import com.example.appointmentapp.utils.argumentCaptor
import com.example.appointmentapp.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import java.math.BigDecimal
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class AppointmentDetailsTest {
    @Inject
    lateinit var appointmentPresenter: AppointmentPresenter

    private lateinit var appointmentScreen: AppointmentScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        appointmentScreen = mock()
        appointmentPresenter.attachScreen(appointmentScreen)
    }

    @Test
    fun testGetAppointment() {
        appointmentPresenter.refreshAppointment(APPOINTMENT_ID)

        val item = argumentCaptor<Appointment>()
        Mockito.verify(appointmentScreen).showAppointmentDetails(item.capture())
        assert(item.value.id == APPOINTMENT_ID)
        assert(item.value.title == APPOINTMENT_TITLE)
        assert(item.value.dateAndTime == APPOINTMENT_START)
        assert(item.value.endDateAndTime == APPOINTMENT_END)
        assert(item.value.duration == APPOINTMENT_DURATION)
        assert(item.value.remarks == APPOINTMENT_DESCRIPTION)
    }

    @After
    fun tearDown() {
        appointmentPresenter.detachScreen()
    }

    companion object {
        private const val APPOINTMENT_ID = "id1"
        private const val APPOINTMENT_TITLE = "Appointment1"
        private const val APPOINTMENT_START = "2021-06-01T14:45:00.000Z"
        private const val APPOINTMENT_END = "2021-06-01T14:45:00.000Z"
        private val APPOINTMENT_DURATION = BigDecimal(30)
        private const val APPOINTMENT_DESCRIPTION = "Same as last time"
    }
}