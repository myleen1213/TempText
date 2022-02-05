package com.example.android.temptext.network

import com.squareup.moshi.Json
import java.util.concurrent.locks.Condition

class WeatherResponse (
    @Json(name = "location") val currentLocation: NestedWeatherResponse?,
    @Json(name = "current") val currentWeather: NestedWeatherResponse?,

)