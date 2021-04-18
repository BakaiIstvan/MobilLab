package com.example.appointmentapp.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class AppointmentsResponse (

    @SerializedName("_links")
    var links: UserLinks? = null,

    @SerializedName("_embedded")
    var embedded: AppointmentsEmbedded? = null,

    @SerializedName("count")
    var count: BigDecimal? = null

)