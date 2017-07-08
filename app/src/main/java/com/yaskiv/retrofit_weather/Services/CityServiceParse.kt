package com.yaskiv.retrofit_weather.Services

import com.yaskiv.retrofit_weather.Model.City.c_City
import retrofit.Call
import retrofit.http.GET

/**
 * Created by VB on 03.07.2017.
 */
interface CityServiceParse {
    @GET("lutangar/cities.json/master/cities.json")
    fun getCity(): Call<List<c_City>>

}
