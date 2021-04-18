package com.example.appointmentapp.model

import com.google.gson.annotations.SerializedName

data class DeleteResponse (
    @SerializedName("message")
    var message: String? = null
)