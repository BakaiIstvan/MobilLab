package com.example.appointmentapp.network

import com.example.appointmentapp.model.*
import retrofit2.Call
import retrofit2.http.*

interface AppointmentsAPI {

    @DELETE("appointments/{id}")
    fun deleteAppointmentsId(
            @retrofit2.http.Path("id") id: String?
    ): Call<DeleteResponse?>?

    @GET("appointments")
    fun getAppointments(
            @Header("Authorization") authorisation: String
    ): Call<AppointmentsResponse?>?

    @GET("appointments/{id}")
    fun getAppointmentsId(
            @Header("Authorization") authorisation: String,
            @retrofit2.http.Path("id") id: String?
    ): Call<Appointment?>?

    @get:GET("auth/google")
    val authGoogle: Call<Any?>?

    @get:GET("me")
    val me: Call<User?>?

    @get:GET("auth/loggedin")
    val user: Call<Any?>?

    @Headers("Content-Type:application/json")
    @PATCH("appointments/{id}")
    fun patchAppointmentsId(
            @Header("Authorization") authorisation: String,
            @retrofit2.http.Path("id") id: String?,
            @retrofit2.http.Body body: AppointmentBody?
    ): Call<Appointment?>?

    @Headers("Content-Type:application/json")
    @POST("appointments")
    fun postAppointments(
            @Header("Authorization") authorisation: String,
            @retrofit2.http.Body body: AppointmentBody?
    ): Call<Appointment?>?

    @Headers("Content-Type:application/json")
    @POST("auth/google")
    fun postAuthGoogle(
            @retrofit2.http.Body body: Token?
    ): Call<GoogleResponse?>?

    @Headers("Content-Type:application/json")
    @PUT("appointments/{id}")
    fun putAppointmentsId(
            @Header("Authorization") authorisation: String,
            @retrofit2.http.Path("id") id: String?,
            @retrofit2.http.Body body: AppointmentBody?
    ): Call<Appointment?>?
}