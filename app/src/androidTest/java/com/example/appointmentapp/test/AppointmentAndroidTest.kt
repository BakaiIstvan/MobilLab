package com.example.appointmentapp.test

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.appointmentapp.R
import com.example.appointmentapp.ui.appointment.AppointmentDetailsActivity
import com.example.appointmentapp.utils.AndroidTestUtils
import com.example.appointmentapp.utils.ElapsedTimeIdlingResource
import com.example.appointmentapp.utils.EspressoTest
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal

class AppointmentAndroidTest : EspressoTest<AppointmentDetailsActivity>(AppointmentDetailsActivity::class.java) {
    @Before
    fun setUp() {
        AndroidTestUtils.setTestInjector()
        activityRule.launchActivity(Intent().putExtra("APPOINTMENT_ID", APPOINTMENT_ID))
    }

    @Test
    fun testLoad() {
        Espresso.onView(ViewMatchers.withId(R.id.start_card_value))
            .check(ViewAssertions.matches(ViewMatchers.withText(APPOINTMENT_START)))
        Espresso.onView(ViewMatchers.withId(R.id.end_card_value))
            .check(ViewAssertions.matches(ViewMatchers.withText(APPOINTMENT_END)))
        Espresso.onView(ViewMatchers.withId(R.id.duration_card_value))
            .check(ViewAssertions.matches(ViewMatchers.withText(APPOINTMENT_DURATION.toString())))
        Espresso.onView(ViewMatchers.withId(R.id.description_card_value))
            .check(ViewAssertions.matches(ViewMatchers.withText(APPOINTMENT_DESCRIPTION)))
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