package com.yaskiv.retrofit_weather.Model.Weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by yaski on 03.07.2017.
 */
class Clouds {
    @com.google.gson.annotations.SerializedName("all")
    @com.google.gson.annotations.Expose
    var all: Int? = null
}