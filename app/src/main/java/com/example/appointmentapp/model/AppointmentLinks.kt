package com.example.appointmentapp.model

import com.google.gson.annotations.SerializedName

data class AppointmentLinks (
    @SerializedName("self")
    var self: UserLinksSelf? = null,

    @SerializedName("user")
    var user: AppointmentLinksUser? = null
)