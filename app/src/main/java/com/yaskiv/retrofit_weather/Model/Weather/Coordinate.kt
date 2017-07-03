package com.yaskiv.retrofit_weather.Model.Weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by yaski on 03.07.2017.
 */
open class Coordinate {
    @com.google.gson.annotations.SerializedName("lon")
    @com.google.gson.annotations.Expose
    var lon: Double? = null
    @com.google.gson.annotations.SerializedName("lat")
    @com.google.gson.annotations.Expose
    var lat: Double? = null
}