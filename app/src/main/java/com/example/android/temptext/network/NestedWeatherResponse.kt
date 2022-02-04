package com.example.android.temptext.network

import com.squareup.moshi.Json

class NestedWeatherResponse (
    @Json(name = "name") val city: String?,
    @Json(name = "localtime") val localTime: String?,

)