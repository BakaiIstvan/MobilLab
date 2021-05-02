package com.example.appointmentapp.ui.appointment

import com.example.appointmentapp.interactor.appointments.AppointmentInteractor
import com.example.appointmentapp.interactor.appointments.event.GetAppointmentEvent
import com.example.appointmentapp.interactor.appointments.event.GetAppointmentsEvent
import com.example.appointmentapp.model.Appointment
import com.example.appointmentapp.ui.Presenter
import com.example.appointmentapp.ui.appointments.AppointmentsScreen
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class AppointmentPresenter @Inject constructor(private val executor: Executor, private val appointmentsInteractor: AppointmentInteractor) : Presenter<AppointmentScreen?>() {
    override fun attachScreen(screen: AppointmentScreen?) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshAppointment(id: String?) {
        if (id != null) {
            executor.execute {
                appointmentsInteractor.getAppointment(id)
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetAppointmentEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.appointment != null) {
                    screen?.showAppointmentDetails(event.appointment as Appointment)
                }

            }
        }
    }
}