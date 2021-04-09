package hu.bme.aut.weatherdemo.ui.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appointmentapp.R
import com.example.appointmentapp.model.Appointment

class AppointmentDetailsActivity : AppCompatActivity(), AppointmentScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        AppointmentPresenter.attachScreen(this)
    }

    override fun onStop() {
        AppointmentPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun showAppointmentDetails(appointment: Appointment) {}

    override fun showError(errorMsg: String) {}
}