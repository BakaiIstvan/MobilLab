package com.example.appointmentapp.model

import com.google.gson.annotations.SerializedName

data class Token (

    @SerializedName("token")
    var token: String? = null
)
