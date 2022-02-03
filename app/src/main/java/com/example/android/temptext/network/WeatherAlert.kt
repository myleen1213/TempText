package com.example.android.temptext.network

import com.squareup.moshi.Json
import java.util.concurrent.locks.Condition

class WeatherAlert (
    @Json(name = "current") val currentWeather: String,
    @Json(name = "location") val currentLocation: String
)