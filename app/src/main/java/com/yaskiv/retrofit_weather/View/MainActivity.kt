package com.yaskiv.retrofit_weather.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import com.yaskiv.retrofit_weather.R
import com.yaskiv.retrofit_weather.Services.WeatherServiceAPI
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun Click(view: View) {
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

        weatherServiceAPI.getWeather("London", getString(R.string.API_Key))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { weather ->
                            Log.d("City : ", weather.name)
                            Log.d("Weather : ", (weather.main!!.temp!! - 273.15).toString())

                        },
                        { error ->
                            Log.e("Error", error.message)
                        }
                )
    }
}
