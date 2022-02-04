package com.example.android.temptext.network

import com.squareup.moshi.Json

class WeatherConditions (
    @Json(name = "text") val currentWeather: String?,
    @Json(name = "icon") val weatherIcon: String?,
    @Json(name = "condition") val weatherCondition: ConditionDetails?
)