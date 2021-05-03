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
    override fun deleteAppointmentsId(
        @Header(value = "Authorization") authorisation: String,
        @Path(value = "id") id: String?
    ): Call<DeleteResponse?>? {
        val deleteResponse = DeleteResponse("Appointment deleted")
        val call = object : Call<DeleteResponse?> {
            @Throws(IOException::class)
            override fun execute(): Response<DeleteResponse?> {
                return Response.success(deleteResponse)
            }

            override fun enqueue(callback: Callback<DeleteResponse?>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<DeleteResponse?> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override fun getAppointments(authorisation: String): Call<AppointmentsResponse?>? {
        val appointmentList = listOf(Appointment(null
                                               , "id1"
                                               , "AppointmentList1"
                                               , "2021-06-02T14:45:00.000Z"
                                               , "2021-06-02T14:45:00.000Z"
                                               , BigDecimal(30)
                                               , "Appointments list item"))
        val appointmentsEmbedded = AppointmentsEmbedded(appointmentList as MutableList<Appointment>)
        val appointmentsResponse = AppointmentsResponse(null, appointmentsEmbedded, BigDecimal(1))

        val call = object : Call<AppointmentsResponse?> {
            @Throws(IOException::class)
            override fun execute(): Response<AppointmentsResponse?> {
                return Response.success(appointmentsResponse)
            }

            override fun enqueue(callback: Callback<AppointmentsResponse?>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<AppointmentsResponse?> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override fun getAppointmentsId(@Header(value = "Authorization") authorisation: String, @Path(value = "id") id: String?): Call<Appointment?>? {
        val appointment = Appointment(null
                                    , "id1"
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

            override fun enqueue(callback: Callback<Appointment?>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

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
        get() = null
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

                override fun enqueue(callback: Callback<User?>) {}

                override fun isExecuted(): Boolean {
                    return false
                }

                override fun cancel() {}

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
        get() = null

    override fun patchAppointmentsId(authorisation: String, id: String?, body: AppointmentBody?): Call<Appointment?>? {
        val appointment = Appointment(null
                                    , "id1"
                                    , "PatchAppointment1"
                                    , "2021-06-01T14:45:00.000Z"
                                    , "2021-06-01T14:45:00.000Z"
                                    , BigDecimal(30)
                                    , "Same as last time")

        val call = object : Call<Appointment?> {
            @Throws(IOException::class)
            override fun execute(): Response<Appointment?> {
                return Response.success(appointment)
            }

            override fun enqueue(callback: Callback<Appointment?>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

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

    override fun postAppointments(authorisation: String, body: AppointmentBody?): Call<Appointment?>? {
        val appointment = Appointment(null
                                    , "id1"
                                    , "PostAppointment1"
                                    , "2021-06-01T14:45:00.000Z"
                                    , "2021-06-01T14:45:00.000Z"
                                    , BigDecimal(30)
                                    , "Same as last time")

        val call = object : Call<Appointment?> {
            @Throws(IOException::class)
            override fun execute(): Response<Appointment?> {
                return Response.success(appointment)
            }

            override fun enqueue(callback: Callback<Appointment?>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

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

    override fun postAuthGoogle(body: Token): Call<GoogleResponse> {
        val googleResponse = GoogleResponse("Google authentication message", "123456789abc", null)
        val call = object : Call<GoogleResponse> {
            @Throws(IOException::class)
            override fun execute(): Response<GoogleResponse?> {
                return Response.success(googleResponse)
            }

            override fun enqueue(callback: Callback<GoogleResponse?>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<GoogleResponse> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override fun putAppointmentsId(authorisation: String, id: String?, body: AppointmentBody?): Call<Appointment?>? {
        val appointment = Appointment(null
                                    , "id1"
                                    , "PutAppointment1"
                                    , "2021-06-01T14:45:00.000Z"
                                    , "2021-06-01T14:45:00.000Z"
                                    , BigDecimal(30)
                                    , "Same as last time")

        val call = object : Call<Appointment?> {
            @Throws(IOException::class)
            override fun execute(): Response<Appointment?> {
                return Response.success(appointment)
            }

            override fun enqueue(callback: Callback<Appointment?>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

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
}