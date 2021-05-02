package com.example.appointmentapp.test

import com.example.appointmentapp.model.Appointment
import com.example.appointmentapp.model.AppointmentBody
import com.example.appointmentapp.testInjector
import com.example.appointmentapp.ui.appointment.AppointmentScreen
import com.example.appointmentapp.ui.newappointment.NewAppointmentPresenter
import com.example.appointmentapp.ui.newappointment.NewAppointmentScreen
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
class NewAppointmentTest {
    @Inject
    lateinit var newAppointmentPresenter: NewAppointmentPresenter

    private lateinit var newAppointmentScreen: NewAppointmentScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        newAppointmentScreen = mock()
        newAppointmentPresenter.attachScreen(newAppointmentScreen)
    }

    @Test
    fun testSaveAppointment() {
        val appointmentBody = AppointmentBody(APPOINTMENT_TITLE, APPOINTMENT_START, APPOINTMENT_END, APPOINTMENT_DURATION, APPOINTMENT_DESCRIPTION)
        newAppointmentPresenter.saveAppointment(appointmentBody)

        val item = argumentCaptor<String>()
        Mockito.verify(newAppointmentScreen).showAppointmentSaved(item.capture())
        assert(item.value == APPOINTMENT_ID)
    }

    @Test
    fun testLoadAppointment() {
        newAppointmentPresenter.loadAppointment(APPOINTMENT_ID)

        val item = argumentCaptor<Appointment>()
        Mockito.verify(newAppointmentScreen).loadAppointment(item.capture())
        assert(item.value.id == APPOINTMENT_ID)
        assert(item.value.title == APPOINTMENT_TITLE)
        assert(item.value.dateAndTime == APPOINTMENT_START)
        assert(item.value.endDateAndTime == APPOINTMENT_END)
        assert(item.value.duration == APPOINTMENT_DURATION)
        assert(item.value.remarks == APPOINTMENT_DESCRIPTION)
    }

    @Test
    fun testModifyAppointment() {
        val appointmentBody = AppointmentBody(APPOINTMENT_TITLE, APPOINTMENT_START, APPOINTMENT_END, APPOINTMENT_DURATION, APPOINTMENT_DESCRIPTION)
        newAppointmentPresenter.modifyAppointment(APPOINTMENT_ID, appointmentBody)

        val item = argumentCaptor<String>()
        Mockito.verify(newAppointmentScreen).showAppointmentModified(item.capture())
        assert(item.value == APPOINTMENT_ID)
    }

    @After
    fun tearDown() {
        newAppointmentPresenter.detachScreen()
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