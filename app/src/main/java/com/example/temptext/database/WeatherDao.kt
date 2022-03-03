package com.example.temptext.database

import androidx.lifecycle.LiveData


interface WeatherDao {
    @Query("SELECT * FROM WeatherImages")
    fun getAll():LiveData<List<WeatherImages>>

    @Query("SELECT * FROM WeatherImages ORDER BY id DESC LIMIT 1")
    fun getMostRecentlyAddWeather (): WeatherImage

    @Query ( "DELETE from WeatherImages where id = (select max (id)-1 from WeatherImages)")
    suspend fun deleteWeather()

    @Insert
    suspend fun addWeatherImage (weatherImageEntity: WeatherImage)

    @Delete
    void delete (User user);
}