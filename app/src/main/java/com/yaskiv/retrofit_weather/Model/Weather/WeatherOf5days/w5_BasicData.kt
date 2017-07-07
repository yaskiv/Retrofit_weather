package com.yaskiv.retrofit_weather.Model.Weather.WeatherOf5days

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.yaskiv.retrofit_weather.Model.Weather.*
import com.yaskiv.retrofit_weather.Model.Weather.WeatherOf1day.w1_BasicData


/**
 * Created by yaski on 07.07.2017.
 */
class w5_BasicData {
    @SerializedName("dt")
    @Expose
    var dt: Int? = null
    @SerializedName("main")
    @Expose
    var main: w1_BasicData? = null
    @SerializedName("weather")
    @Expose
    var weather: List<w_Weather>? = null
    @SerializedName("clouds")
    @Expose
    var clouds: w_Clouds? = null
    @SerializedName("wind")
    @Expose
    var wind: w_Wind? = null
    @SerializedName("rain")
    @Expose
    var rain: w_Rain? = null
    @SerializedName("sys")
    @Expose
    var sys: w_System? = null
    @SerializedName("dt_txt")
    @Expose
    var dtTxt: String? = null
}