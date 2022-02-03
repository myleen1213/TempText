package com.example.android.temptext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.android.temptext.network.WeatherAlert
import com.example.android.temptext.network.WeatherAlertApi
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherInfo = MutableLiveData<WeatherAlert>()

        try {
            lifecycleScope.launch {
                weatherInfo.value = WeatherAlertApi.retrofitService.getCurrentWeather()
            }
        } catch (e: Exception) {
            "Failure: ${e.message}"
        }
    }
}