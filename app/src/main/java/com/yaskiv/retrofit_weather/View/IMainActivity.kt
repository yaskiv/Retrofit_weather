package com.yaskiv.retrofit_weather.View

import android.view.View

/**
 * Created by yaski on 03.07.2017.
 */
interface IMainActivity {
    fun Click(view: View)
    fun UpdateCityName(city_name_from_Api: String)
    fun UpdateCityTemperature(city_temperature_from_Api: String)
    fun Click1(view: View)
    fun Click2(view: View)
}