package com.example.android.temptext.network

import com.squareup.moshi.Json

class ConditionDetails (
    @Json(name = "text") val currentCondition: String?,
    @Json(name = "icon") val weatherIcon: String?,
    @Json(name = "temp_c") val celsius: Float,
    @Json(name = "temp_f") val fahrenheit: Float
)