package com.Yi.videoplayer.utils

import android.text.format.DateFormat
import java.sql.Timestamp
import java.text.SimpleDateFormat

object DateUtils {

    fun getCurrentTime():Long
    {
        return Timestamp(System.currentTimeMillis()).time
    }
}