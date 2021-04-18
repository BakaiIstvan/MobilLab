package com.example.appointmentapp.model

import com.google.gson.annotations.SerializedName

data class GoogleResponse (
    @SerializedName("message")
    var message: String? = null,

    @SerializedName("token")
    var token: String? = null,

    @SerializedName("_links")
    var links: GoogleLinks? = null
)