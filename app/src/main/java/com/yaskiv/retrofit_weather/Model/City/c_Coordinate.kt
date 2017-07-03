package com.yaskiv.retrofit_weather.Model.City

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by VB on 03.07.2017.
 */
open class c_Coordinate {
    @SerializedName("lon")
    @Expose
    var lon: Double? = null
    @SerializedName("lat")
    @Expose
    var lat: Int? = null
}