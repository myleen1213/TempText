package com.example.android.temptext

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.android.temptext.network.WeatherAlertApi
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val city = MutableLiveData<String>()
        val state = MutableLiveData<String>()
        val currentWeather = MutableLiveData<String>()
        val weatherIcon = MutableLiveData<String>()
        val celsius = MutableLiveData<Float>()
        val fahrenheit = MutableLiveData<Float>()

        try {
            lifecycleScope.launch {
                city.value = WeatherAlertApi.retrofitService.getCurrentWeather().currentLocation?.city
                state.value = WeatherAlertApi.retrofitService.getCurrentWeather().currentLocation?.state
                currentWeather.value = WeatherAlertApi.retrofitService.getCurrentWeather().currentWeather?.currentWeatherCondition?.currentCondition
                weatherIcon.value = WeatherAlertApi.retrofitService.getCurrentWeather().currentWeather?.currentWeatherCondition?.weatherIcon
                celsius.value = WeatherAlertApi.retrofitService.getCurrentWeather().currentWeather?.celsius
                fahrenheit.value = WeatherAlertApi.retrofitService.getCurrentWeather().currentWeather?.fahrenheit

                Log.d("MainActivityCity",city.value.toString())
                Log.d("MainActivityCity",state.value.toString())
                Log.d("MainActivityWeather", currentWeather.value.toString())
                Log.d("MainActivityIcon", weatherIcon.value.toString())
                Log.d("MainActivityCel", celsius.value.toString())
                Log.d("MainActivityFahr", fahrenheit.value.toString())
            }
        } catch (e: Exception) {
            "Failure: ${e.message}"
        }
    }
}