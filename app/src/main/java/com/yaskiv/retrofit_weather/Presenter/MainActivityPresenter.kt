package com.yaskiv.retrofit_weather.Presenter

import android.util.Log
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import com.yaskiv.retrofit_weather.Services.WeatherServiceAPI
import com.yaskiv.retrofit_weather.View.IMainActivity
import com.yaskiv.retrofit_weather.View.Impl.MainActivity
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by yaski on 03.07.2017.
 */
class MainActivityPresenter(var mActivity: IMainActivity) {

    fun getWeather(city_name: String, api_key: String): Unit {
        val gson = GsonBuilder().setExclusionStrategies(object : ExclusionStrategy {
            override fun shouldSkipField(f: FieldAttributes): Boolean {
                return false
            }

            override fun shouldSkipClass(clazz: Class<*>): Boolean {
                return false
            }
        }).create()

        val retrofit: Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://api.openweathermap.org/")
                .build()

        val weatherServiceAPI: WeatherServiceAPI = retrofit.create(
                WeatherServiceAPI::class.java)

        weatherServiceAPI.getWeather(city_name, api_key)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { weather ->
                            mActivity.UpdateCityName(weather.name!!)
                            mActivity.UpdateCityTemperature((weather.main!!.temp!! - 273.15).toString())
                            Log.d("City : ", weather.name)
                            Log.d("Weather : ", (weather.main!!.temp!! - 273.15).toString())

                        },
                        { error ->
                            Log.e("Error", error.message)
                        }
                )
    }
}