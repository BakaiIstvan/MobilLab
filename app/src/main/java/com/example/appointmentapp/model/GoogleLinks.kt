package com.example.appointmentapp.model

import com.google.gson.annotations.SerializedName

data class GoogleLinks (
    @SerializedName("self")
    var self: UserLinksSelf? = null,

    @SerializedName("me")
    var me: UserLinksSelf? = null,

    @SerializedName("appointments")
    var appointments: UserLinksSelf? = null

)