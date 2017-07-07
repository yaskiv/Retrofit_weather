package com.yaskiv.retrofit_weather.Model.Weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.yaskiv.retrofit_weather.Model.Weather.w_Coordinate


/**
 * Created by yaski on 07.07.2017.
 */
class w_City {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("coord")
    @Expose
    var coord: w_Coordinate? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
}