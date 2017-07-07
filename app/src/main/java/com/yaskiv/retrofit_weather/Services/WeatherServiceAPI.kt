package com.yaskiv.retrofit_weather.Services

import com.yaskiv.retrofit_weather.Model.Weather.WeatherOf1day.w1_API
import com.yaskiv.retrofit_weather.Model.Weather.WeatherOf5days.w5_API
import retrofit.http.GET
import retrofit.http.Query
import rx.Observable


/**
 * Created by yaski on 03.07.2017.
 */
interface WeatherServiceAPI {
    @GET("data/2.5/weather?")
    fun getWeather(@Query("q") cityName: String, @Query("appid") api_key: String): Observable<w1_API>

    //api.openweathermap.org/data/2.5/weather?lat=35&lon=139
    @GET("data/2.5/weather?")
    fun getWeatherByLocation(@Query("lat") lat: String, @Query("lon") lon: String, @Query("appid") api_key: String): Observable<w1_API>

    //api.openweathermap.org/data/2.5/forecast?lat=35&lon=139
    @GET("data/2.5/forecast?")
    fun getWeatherOf5DaysByLocation(@Query("lat") lat: String, @Query("lon") lon: String, @Query("appid") api_key: String): Observable<w5_API>


}