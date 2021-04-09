package com.example.appointmentapp

import android.app.Activity


val Activity.injector: AppointmentApplicationComponent
    get() {
        return (this.applicationContext as AppointmentApplication).injector
    }

