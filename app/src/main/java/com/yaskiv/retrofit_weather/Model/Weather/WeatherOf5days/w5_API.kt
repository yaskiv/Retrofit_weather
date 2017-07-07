package com.yaskiv.retrofit_weather.Model.Weather.WeatherOf5days

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.yaskiv.retrofit_weather.Model.Weather.w_City


/**
 * Created by yaski on 07.07.2017.
 */
class w5_API {

    @SerializedName("cod")
    @Expose
    var cod: String? = null
    @SerializedName("message")
    @Expose
    var message: Double? = null
    @SerializedName("cnt")
    @Expose
    var cnt: Int? = null
    @SerializedName("list")
    @Expose
    var list: List<w5_BasicData>? = null
    @SerializedName("city")
    @Expose
    var city: w_City? = null
}