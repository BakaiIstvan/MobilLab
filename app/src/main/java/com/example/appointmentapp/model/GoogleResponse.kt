package com.example.appointmentapp.model

import com.google.gson.annotations.SerializedName

data class GoogleResponse (
    @SerializedName("message")
    var message: String? = null,

    @SerializedName("token")
    var token: String,

    @SerializedName("links")
    var links: GoogleLinks? = null
)