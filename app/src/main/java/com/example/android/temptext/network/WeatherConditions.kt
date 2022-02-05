package com.example.android.temptext.network

import com.squareup.moshi.Json

class WeatherConditions (
    @Json(name = "text") val currentCondition: String?,
    @Json(name = "icon") val weatherIcon: String?,
)