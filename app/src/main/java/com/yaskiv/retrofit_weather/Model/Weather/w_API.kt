package com.yaskiv.retrofit_weather.Model.Weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by yaski on 03.07.2017.
 */

open class w_API() {

    @SerializedName("coord")
    @Expose
    var coord: w_Coordinate? = null
    @SerializedName("weather")
    @Expose
    var weather: List<w_Weather>? = null
    @SerializedName("base")
    @Expose
    var base: String? = null
    @SerializedName("main")
    @Expose
    var main: w_Basic_temperature? = null
    @SerializedName("wind")
    @Expose
    var wind: w_Wind? = null
    @SerializedName("clouds")
    @Expose
    var clouds: w_Clouds? = null
    @SerializedName("rain")
    @Expose
    var rain: w_Rain? = null
    @SerializedName("dt")
    @Expose
    var dt: Int? = null
    @SerializedName("sys")
    @Expose
    var sys: w_System? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("cod")
    @Expose
    var cod: Int? = null
}