package com.example.appointmentapp.model

import com.google.gson.annotations.SerializedName

data class UserLinks (
    @SerializedName("self")
    var self: UserLinksSelf? = null
)