package com.example.appointmentapp.model

import com.google.gson.annotations.SerializedName

data class UserLinksSelf (
    @SerializedName("href")
    var href: String? = null
)