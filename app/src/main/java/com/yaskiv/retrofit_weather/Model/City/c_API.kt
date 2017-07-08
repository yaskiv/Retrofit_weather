package com.yaskiv.retrofit_weather.Model.City

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.RealmClass


/**
 * Created by yaski on 03.07.2017.
 */
@RealmClass
open class c_API : RealmObject() {
    var citys = RealmList<c_City> ()
            //mutableListOf<c_City>()

}