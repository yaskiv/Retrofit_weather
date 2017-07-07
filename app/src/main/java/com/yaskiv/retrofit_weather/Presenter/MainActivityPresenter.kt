package com.yaskiv.retrofit_weather.Presenter

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.util.Log
import com.google.android.gms.location.LocationRequest
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import com.ninenine.reactivelocation.FusedLocationApiProvider
import com.ninenine.reactivelocation.LocationConnectionException
import com.ninenine.reactivelocation.LocationManager
import com.yaskiv.retrofit_weather.Model.Weather.WeatherOf5days.w5_BasicData
import com.yaskiv.retrofit_weather.Services.WeatherServiceAPI
import com.yaskiv.retrofit_weather.View.IMainActivity
import retrofit.*
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by yaski on 03.07.2017.
 */
class MainActivityPresenter(var mActivity: IMainActivity) {
    var subscription: Subscription? = null
    var weatherServiceAPI: WeatherServiceAPI? = null
    fun getWeather(city_name: String, api_key: String): Unit {
        if (weatherServiceAPI == null)
            InitAPI()

        weatherServiceAPI!!.getWeather(city_name, api_key)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { weather ->
                            mActivity.UpdateCityName(weather.name!!)
                            mActivity.UpdateCityTemperature((weather.main!!.temp!! - 273.15).toString())
                            Log.d("w_City : ", weather.name)
                            Log.d("Weather : ", (weather.main!!.temp!! - 273.15).toString())

                        },
                        { error ->
                            Log.e("Error", error.message)
                        }
                )
    }

    fun unsubscribe(): Unit {
        if (subscription != null)
            subscription?.unsubscribe()
    }

    fun CheckPermissions(context: Context, activity: Activity): Unit {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
        (context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION), 1)

        }

    }

    fun getLocation(context: Context, API_KEY: String, type: Int): Unit {

        val locationApiProvider = FusedLocationApiProvider()
        val locationManager = LocationManager(locationApiProvider)
        val locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setNumUpdates(1)

        subscription = locationManager.streamForRequest(context, locationRequest).subscribe(
                { location ->
                    Log.d("Location", location.toString())
                    if (type == 1)
                        getWeatherByLocation(location.latitude.toString(), location.longitude.toString(), API_KEY)
                    if (type == 2)
                        getWeatherByLocationOf5days(location.latitude.toString(), location.longitude.toString(), API_KEY)
                },
                { error ->
                    // Check if the error has solution. Settings or Permission exceptions
                    if (error is LocationConnectionException && error.hasSolution()) {

                    }
                }
        )
    }


    fun InitAPI(): Unit {
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

        weatherServiceAPI = retrofit.create(
                WeatherServiceAPI::class.java)
    }

    fun getWeatherByLocationOf5days(lat: String, lon: String, api_key: String): Unit {

        if (weatherServiceAPI == null)
            InitAPI()

        weatherServiceAPI!!.getWeatherOf5DaysByLocation(lat, lon, api_key)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { weather ->
                            mActivity.UpdateCityName(weather.city!!.name!!)
                            for (ob: w5_BasicData in weather.list!!) {
                                Log.d("Weather", (ob.main!!.temp!! - 273.15).toString())
                            }

                        },
                        { error ->
                            Log.e("Error", error.message)
                        }
                )
    }


    fun getWeatherByLocation(lat: String, lon: String, api_key: String): Unit {

        if (weatherServiceAPI == null)
            InitAPI()

        weatherServiceAPI!!.getWeatherByLocation(lat, lon, api_key)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { weather ->
                            mActivity.UpdateCityName(weather.name!!)
                            mActivity.UpdateCityTemperature((weather.main!!.temp!! - 273.15).toString())

                        },
                        { error ->
                            Log.e("Error", error.message)
                        }
                )
    }
}