package com.yaskiv.retrofit_weather.Model.City

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by VB on 03.07.2017.
 */
@RealmClass
open class c_City : RealmObject() {
    @SerializedName("country")
    @Expose
    var country: String? = null
    @PrimaryKey
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("lat")
    @Expose
    var lat: String? = null
    @SerializedName("lng")
    @Expose
    var lng: String? = null
}