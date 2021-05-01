package com.example.appointmentapp.mock

import com.example.appointmentapp.model.*
import com.example.appointmentapp.network.AppointmentsAPI
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Path
import java.io.IOException
import java.math.BigDecimal

class MockAppointmentsAPI() : AppointmentsAPI{
    override fun deleteAppointmentsId(id: String?): Call<DeleteResponse?>? {
        TODO("Not yet implemented")
    }

    override fun getAppointments(authorisation: String): Call<AppointmentsResponse?>? {
        TODO("Not yet implemented")
    }

    override fun getAppointmentsId(@Header(value = "Authorization") authorisation: String, @Path(value = "id") id: String?): Call<Appointment?>? {
        val appointment = Appointment(null
                                    , id
                                    , "Appointment1"
                                    , "2021-06-01T14:45:00.000Z"
                                    , "2021-06-01T14:45:00.000Z"
                                    , BigDecimal(30)
                                    , "Same as last time")

        val call = object : Call<Appointment?> {
            @Throws(IOException::class)
            override fun execute(): Response<Appointment?> {
                return Response.success(appointment)
            }

            override fun enqueue(callback: Callback<Appointment?>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<Appointment?> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override val authGoogle: Call<Any?>?
        get() = TODO("Not yet implemented")
    override val me: Call<User?>?
        get() {
            val roles: MutableList<Any> = mutableListOf<Any>()
            roles.add("customer")
            val user = User(null
                          , "id1"
                          , "google"
                          , "someone@gmail.com"
                          , "Nice Name"
                          , roles)

            val call = object : Call<User?> {
                @Throws(IOException::class)
                override fun execute(): Response<User?> {
                    return Response.success(user)
                }

                override fun enqueue(callback: Callback<User?>) {

                }

                override fun isExecuted(): Boolean {
                    return false
                }

                override fun cancel() {

                }

                override fun isCanceled(): Boolean {
                    return false
                }

                override fun clone(): Call<User?> {
                    return this
                }

                override fun request(): Request? {
                    return null
                }
            }

            return call
        }
    override val user: Call<Any?>?
        get() = TODO("Not yet implemented")

    override fun patchAppointmentsId(authorisation: String, id: String?, body: AppointmentBody?): Call<Appointment?>? {
        TODO("Not yet implemented")
    }

    override fun postAppointments(authorisation: String, body: AppointmentBody?): Call<Appointment?>? {
        TODO("Not yet implemented")
    }

    override fun postAuthGoogle(body: Token): Call<GoogleResponse> {
        TODO("Not yet implemented")
    }

    override fun putAppointmentsId(authorisation: String, id: String?, body: AppointmentBody?): Call<Appointment?>? {
        TODO("Not yet implemented")
    }
}