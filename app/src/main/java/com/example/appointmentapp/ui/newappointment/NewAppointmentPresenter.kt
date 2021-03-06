package com.example.appointmentapp.ui.newappointment

import com.example.appointmentapp.interactor.appointments.NewAppointmentInteractor
import com.example.appointmentapp.interactor.appointments.event.GetAppointmentEvent
import com.example.appointmentapp.interactor.appointments.event.SaveAppointmentEvent
import com.example.appointmentapp.interactor.appointments.event.UpdateAppointmentEvent
import com.example.appointmentapp.model.Appointment
import com.example.appointmentapp.model.AppointmentBody
import com.example.appointmentapp.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class NewAppointmentPresenter @Inject constructor(private val executor: Executor, private val newAppointmentInteractor: NewAppointmentInteractor) : Presenter<NewAppointmentScreen?>() {
    override fun attachScreen(screen: NewAppointmentScreen?) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun saveAppointment(appointment: AppointmentBody) {
        executor.execute {
            newAppointmentInteractor.saveAppointment(appointment)
        }
    }

    fun loadAppointment(id : String?) {
        if (id != null) {
            executor.execute {
                newAppointmentInteractor.getAppointment(id)
            }
        }
    }

    fun modifyAppointment(id: String?, appointment: AppointmentBody) {
        if (id != null) {
            executor.execute {
                newAppointmentInteractor.modifyAppointment(id, appointment)
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: SaveAppointmentEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.appointment != null) {
                    screen?.showAppointmentSaved(event.appointment!!.id as String)
                }

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
                    screen?.loadAppointment(event.appointment as Appointment)
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: UpdateAppointmentEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.id != null) {
                    screen?.showAppointmentModified(event.id!!)
                }
            }
        }
    }
}
