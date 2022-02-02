package com.example.android.temptext.network

import com.squareup.moshi.Json
import java.util.concurrent.locks.Condition

class WeatherAlert (
    @Json(name = "condition") val weatherCondition: String
)