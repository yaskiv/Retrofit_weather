package com.yaskiv.retrofit_weather.Services

import com.yaskiv.retrofit_weather.Model.Weather.*
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query
import rx.Observable


/**
 * Created by yaski on 03.07.2017.
 */
interface WeatherServiceAPI {
    @GET("data/2.5/weather?")
    fun getWeather(@Query("q") cityName: String, @Query("appid") api_key: String): Observable<w_API>

}