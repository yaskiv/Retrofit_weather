package com.yaskiv.retrofit_weather.Model.Weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by yaski on 03.07.2017.
 */
open class API() {

    @SerializedName("coord")
    @Expose
    var coord: Coordinate? = null
    @SerializedName("weather")
    @Expose
    var weather: List<Weather>? = null
    @SerializedName("base")
    @Expose
    var base: String? = null
    @SerializedName("main")
    @Expose
    var main: Main? = null
    @SerializedName("wind")
    @Expose
    var wind: Wind? = null
    @SerializedName("clouds")
    @Expose
    var clouds: Clouds? = null
    @SerializedName("rain")
    @Expose
    var rain: Rain? = null
    @SerializedName("dt")
    @Expose
    var dt: Int? = null
    @SerializedName("sys")
    @Expose
    var sys: Sys? = null
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