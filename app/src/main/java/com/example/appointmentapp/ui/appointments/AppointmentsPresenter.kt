package com.example.appointmentapp.ui.appointments

import com.example.appointmentapp.interactor.appointments.AppointmentsInteractor
import com.example.appointmentapp.interactor.appointments.event.GetAppointmentsEvent
import com.example.appointmentapp.model.Appointment
import com.example.appointmentapp.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class AppointmentsPresenter @Inject constructor(private val executor: Executor, private val appointmentsInteractor: AppointmentsInteractor) : Presenter<AppointmentsScreen?>() {
    override fun attachScreen(screen: AppointmentsScreen?) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshAppointments() {
        executor.execute {
            appointmentsInteractor.getAppointments()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetAppointmentsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.appointments != null) {
                    screen?.showAppointments(event.appointments as MutableList<Appointment>)
                }

            }
        }
    }
}
