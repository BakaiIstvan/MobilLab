package com.example.appointmentapp.test

import com.example.appointmentapp.R
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.appointmentapp.ui.appointments.AppointmentsActivity
import com.example.appointmentapp.utils.AndroidTestUtils.setTestInjector
import com.example.appointmentapp.utils.EspressoTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class AppointmentsAndroidTest : EspressoTest<AppointmentsActivity>(AppointmentsActivity::class.java) {

    @Before
    fun setUp() {
        setTestInjector()
        activityRule.launchActivity(Intent())
    }

    @Test
    fun testClickAppointment() {
        onView(withId(R.id.appointments_rv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
    }

    @Test
    fun testScrolling() {
        var recyclerView: RecyclerView = activityRule.activity.findViewById(R.id.appointments_rv)
        var itemCount = recyclerView.adapter?.itemCount

        if (itemCount != null) {
            onView(withId(R.id.appointments_rv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(itemCount.minus(1)))
        }
    }

    @Test
    fun testTitleOfItem() {
        onView(ViewMatchers.withId(R.id.appointments_rv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withText(APPOINTMENT_TITLE)).check(matches(isDisplayed()))
    }

    companion object {
        private const val APPOINTMENT_TITLE = "Appointment1"
    }
}