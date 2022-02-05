package com.example.android.temptext.network

import com.squareup.moshi.Json

class NestedWeatherResponse (
    @Json(name = "temp_c") val celsius: Float?,
    @Json(name = "temp_f") val fahrenheit: Float?,
    @Json(name = "name") val city: String?,
    @Json(name = "localtime") val localTime: String?,
    @Json(name = "condition") val currentWeatherCondition: WeatherConditions?,
    @Json(name = "is_day") val dayOfWeek: Int?
)