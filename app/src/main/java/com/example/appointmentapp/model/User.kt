package com.example.appointmentapp.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class User (
    @SerializedName("_links")
    var links: UserLinks? = null,

    @SerializedName("userId")
    var userId: String? = null,

    @SerializedName("provider")
    var provider: String? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("displayName")
    var displayName: String? = null,

    @SerializedName("roles")
    var roles: MutableList<Any> = ArrayList()
)