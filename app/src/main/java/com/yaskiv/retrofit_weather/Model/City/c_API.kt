package com.yaskiv.retrofit_weather.Model.City

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by yaski on 03.07.2017.
 */
open class c_API {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("coord")
    @Expose
    var coord: c_Coordinate? = null
}