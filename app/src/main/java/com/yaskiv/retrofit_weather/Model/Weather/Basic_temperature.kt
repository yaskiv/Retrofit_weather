package com.yaskiv.retrofit_weather.Model.Weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by yaski on 03.07.2017.
 */
open class Basic_temperature {
    @SerializedName("temp")
    @Expose
    var temp: Double? = null
    @SerializedName("pressure")
    @Expose
    var pressure: Int? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null
    @SerializedName("temp_min")
    @Expose
    var tempMin: Double? = null
    @SerializedName("temp_max")
    @Expose
    var tempMax: Double? = null
}