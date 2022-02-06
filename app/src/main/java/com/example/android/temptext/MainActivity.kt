package com.example.android.temptext

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.temptext.network.FusedLocation

//private const val API_KEY = BuildConfig.WEATHER_API_KEY

class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocation: FusedLocation
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fusedLocation.getLastLocation()
        /*val city = MutableLiveData<String>()
        val state = MutableLiveData<String>()
        val currentWeather = MutableLiveData<String>()
        val weatherIcon = MutableLiveData<String>()
        val celsius = MutableLiveData<Float>()
        val fahrenheit = MutableLiveData<Float>()

        try {
            lifecycleScope.launch {
                city.value = WeatherAlertApi.retrofitService.getCurrentWeather(API_KEY,"NY","no").currentLocation?.city
                state.value = WeatherAlertApi.retrofitService.getCurrentWeather(API_KEY,"NY","no").currentLocation?.state
                currentWeather.value = WeatherAlertApi.retrofitService.getCurrentWeather(API_KEY,"NY","no").currentWeather?.currentWeatherCondition?.currentCondition
                weatherIcon.value = WeatherAlertApi.retrofitService.getCurrentWeather(API_KEY,"NY","no").currentWeather?.currentWeatherCondition?.weatherIcon
                celsius.value = WeatherAlertApi.retrofitService.getCurrentWeather(API_KEY,"NY","no").currentWeather?.celsius
                fahrenheit.value = WeatherAlertApi.retrofitService.getCurrentWeather(API_KEY,"NY","no").currentWeather?.fahrenheit

                Log.d("MainActivityCity",city.value.toString())
                Log.d("MainActivityCity",state.value.toString())
                Log.d("MainActivityWeather", currentWeather.value.toString())
                Log.d("MainActivityIcon", weatherIcon.value.toString())
                Log.d("MainActivityCel", celsius.value.toString())
                Log.d("MainActivityFahr", fahrenheit.value.toString())
            }
        } catch (e: Exception) {
            "Failure: ${e.message}"
        }*/
    }
}