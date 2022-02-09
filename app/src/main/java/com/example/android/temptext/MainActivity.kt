package com.example.android.temptext

import android.Manifest
import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.annotation.SuppressLint
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource

//private const val API_KEY = BuildConfig.WEATHER_API_KEY

class MainActivity : AppCompatActivity() {
    /**
     * Provides the entry point to the Fused Location Provider API.
     */
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val cancellationTokenSource = CancellationTokenSource()
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 34
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
         * Instantiates Fused Location Provider
         */
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        /*
        val city = MutableLiveData<String>()
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

    override fun onStart() {
        super.onStart()
        /* *
         * Check permissions when activity starts
         * */
        if (!checkPermissions()) {
            requestPermissions()
        } else {
            getLastLocation()
        }
    }

    /**
     * Provides a simple way of getting a device's location and is well suited for
     * applications that do not require a fine-grained location and that do not need location
     * updates. Gets the best and most recent location currently available, which may be null
     * in rare cases when a location is not available.
     *
     * Note: this method should be called after location permission has been granted.
     */
    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        fusedLocationClient.lastLocation
            .addOnCompleteListener { location ->
                if (location.isSuccessful && location.result != null) {

                    val location = location.result
                    println("$location")

                    Log.d("MainAct", "$location")
                } else {
                    Log.d("MainActError", "getLastLocation:exception", location.exception)
                }
                cancellationTokenSource.cancel()
            }

    }
    /**
     * Return the current state of the permissions needed.
     */
    private fun checkPermissions() =
        ActivityCompat.checkSelfPermission(applicationContext, ACCESS_COARSE_LOCATION) == PERMISSION_GRANTED

    private fun startLocationPermissionRequest() {
        ActivityCompat.requestPermissions(this, arrayOf(ACCESS_COARSE_LOCATION),
            REQUEST_PERMISSIONS_REQUEST_CODE)
    }

    private fun requestPermissions() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, ACCESS_COARSE_LOCATION)) {
            // Provide an additional rationale to the user. This would happen if the user denied the
            // request previously, but didn't check the "Don't ask again" checkbox.
            Log.i(TAG, "Displaying permission rationale to provide additional context.")
            // Request permission
            startLocationPermissionRequest()

        } else {
            // Request permission. It's possible this can be auto answered if device policy
            // sets the permission in a given state or the user denied the permission
            // previously and checked "Never ask again".
            Log.i(TAG, "Requesting permission")
            startLocationPermissionRequest()
        }
    }
}

