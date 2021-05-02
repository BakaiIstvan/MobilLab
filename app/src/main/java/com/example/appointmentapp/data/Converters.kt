package com.example.appointmentapp.data

import androidx.room.TypeConverter
import com.example.appointmentapp.model.AppointmentLinks
import java.math.BigDecimal

class Converters {
    @TypeConverter
    fun bigDecimalToLong(value: BigDecimal?): Long? {
        if (value != null) {
            return value.toLong()
        }
        return 0;
    }

    @TypeConverter
    fun longToBigDecimal(value: Long?): BigDecimal {
        if (value != null) {
            return value.toBigDecimal()
        }
        return BigDecimal(0);
    }

    @TypeConverter
    fun linkToString(value: AppointmentLinks?): String {
        return value.toString()
    }

    @TypeConverter
    fun stringToLinks(value: String?): AppointmentLinks {
        return AppointmentLinks()
    }
}