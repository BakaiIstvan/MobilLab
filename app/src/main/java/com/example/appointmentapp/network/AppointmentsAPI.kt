package com.example.appointmentapp.network

import com.example.appointmentapp.model.*
import retrofit2.http.*
import rx.Observable

interface AppointmentsAPI {

    @DELETE("appointments/{id}")
    fun deleteAppointmentsId(
            @retrofit2.http.Path("id") id: String?
    ): Observable<DeleteResponse?>?

    @get:GET("appointments")
    val appointments: Observable<AppointmentsResponse?>?

    @GET("appointments/{id}")
    fun getAppointmentsId(
            @retrofit2.http.Path("id") id: String?
    ): Observable<Appointment?>?

    @get:GET("auth/google")
    val authGoogle: Observable<Any?>?

    @get:GET("me")
    val me: Observable<User?>?

    @get:GET("auth/loggedin")
    val user: Observable<Any?>?

    @Headers("Content-Type:application/json")
    @PATCH("appointments/{id}")
    fun patchAppointmentsId(
            @retrofit2.http.Path("id") id: String?, @retrofit2.http.Body body: AppointmentBody?
    ): Observable<Appointment?>?

    @Headers("Content-Type:application/json")
    @POST("appointments")
    fun postAppointments(
            @retrofit2.http.Body body: AppointmentBody?
    ): Observable<Appointment?>?

    @Headers("Content-Type:application/json")
    @POST("auth/google")
    fun postAuthGoogle(
            @retrofit2.http.Body body: Token?
    ): Observable<GoogleResponse?>?

    @Headers("Content-Type:application/json")
    @PUT("appointments/{id}")
    fun putAppointmentsId(
            @retrofit2.http.Path("id") id: String?, @retrofit2.http.Body body: AppointmentBody?
    ): Observable<Appointment?>?
}