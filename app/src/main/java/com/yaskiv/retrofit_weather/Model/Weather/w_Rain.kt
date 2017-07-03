package com.yaskiv.retrofit_weather.Model.Weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by yaski on 03.07.2017.
 */
open class w_Rain {
    @SerializedName("3h")
    @Expose
    var _3h: Int? = null
}