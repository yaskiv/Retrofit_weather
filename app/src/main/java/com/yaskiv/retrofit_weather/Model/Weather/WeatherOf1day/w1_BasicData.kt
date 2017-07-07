package com.yaskiv.retrofit_weather.Model.Weather.WeatherOf1day

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by yaski on 03.07.2017.
 */
open class w1_BasicData {
    @SerializedName("temp")
    @Expose
    var temp: Double? = null
    @SerializedName("pressure")
    @Expose
    var pressure: Double? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null
    @SerializedName("temp_min")
    @Expose
    var tempMin: Double? = null
    @SerializedName("temp_max")
    @Expose
    var tempMax: Double? = null
    @SerializedName("sea_level")
    @Expose
    var seaLevel: Double? = null
    @SerializedName("grnd_level")
    @Expose
    var grndLevel: Double? = null
    @SerializedName("temp_kf")
    @Expose
    var tempKf: Double? = null
}