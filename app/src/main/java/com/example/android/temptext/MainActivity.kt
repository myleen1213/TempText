package com.example.android.temptext

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.android.temptext.network.WeatherAlertApi
import kotlinx.coroutines.launch

private const val API_KEY = BuildConfig.WEATHER_API_KEY

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val city = MutableLiveData<String>()
        val state = MutableLiveData<String>()
        val currentWeather = MutableLiveData<String>()
        val celsius = MutableLiveData<Float>()
        val fahrenheit = MutableLiveData<Float>()
        val humidity = MutableLiveData<String>()
        val dayOfWeek = MutableLiveData<Int>()
        val windMph = MutableLiveData<Float>()
        val precipitation = MutableLiveData<Float>()

        try {
            lifecycleScope.launch {
                city.value = WeatherAlertApi.retrofitService.getCurrentWeather("NY","yes").currentLocation?.city
                state.value = WeatherAlertApi.retrofitService.getCurrentWeather("NY","yes").currentLocation?.state
                currentWeather.value = WeatherAlertApi.retrofitService.getCurrentWeather("NY","yes").currentWeather?.currentWeatherCondition?.currentCondition
                celsius.value = WeatherAlertApi.retrofitService.getCurrentWeather("NY","yes").currentWeather?.celsius
                fahrenheit.value = WeatherAlertApi.retrofitService.getCurrentWeather("NY","yes").currentWeather?.fahrenheit
                humidity.value = WeatherAlertApi.retrofitService.getCurrentWeather("NY", "yes").currentWeather?.humidity
                dayOfWeek.value = WeatherAlertApi.retrofitService.getCurrentWeather("NY", "yes").currentWeather?.dayOfWeek
                windMph.value = WeatherAlertApi.retrofitService.getCurrentWeather("NY", "yes").currentWeather?.windMph
                precipitation.value = WeatherAlertApi.retrofitService.getCurrentWeather("NY", "yes").currentWeather?.windMph

                Log.d("MainActivityCity",city.value.toString())
                Log.d("MainActivityCity",state.value.toString())
                Log.d("MainActivityWeather", currentWeather.value.toString())
                Log.d("MainActivityCel", celsius.value.toString())
                Log.d("MainActivityFahr", fahrenheit.value.toString())
            }
        } catch (e: Exception) {
            "Failure: ${e.message}"
        }
    }
}