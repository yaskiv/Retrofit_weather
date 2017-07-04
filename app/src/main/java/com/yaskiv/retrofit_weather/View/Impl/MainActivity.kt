package com.yaskiv.retrofit_weather.View.Impl

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import com.yaskiv.retrofit_weather.Presenter.MainActivityPresenter
import com.yaskiv.retrofit_weather.R
import com.yaskiv.retrofit_weather.Services.WeatherServiceAPI
import com.yaskiv.retrofit_weather.View.IMainActivity
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import android.content.ComponentName
import android.content.Context
import android.os.IBinder
import android.content.ServiceConnection
import android.content.Context.BIND_AUTO_CREATE
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.support.v4.app.ActivityCompat
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.tasks.Tasks.call
import com.ninenine.reactivelocation.FusedLocationApiProvider
import com.ninenine.reactivelocation.LocationConnectionException
import com.ninenine.reactivelocation.LocationManager
import com.yaskiv.retrofit_weather.Services.LocationService

import rx.Subscription
import rx.functions.Action1


class MainActivity : AppCompatActivity(), IMainActivity {
    var editText: EditText? = null
    var city_name: TextView? = null
    var subscription: Subscription? = null
    override fun onStop() {
        super.onStop()
        subscription?.unsubscribe()
    }

    var city_temperature: TextView? = null
    val mPresenter = MainActivityPresenter(this)
    var mService: LocationService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.Edit_text_city_name) as EditText
        city_name = findViewById(R.id.City_Name) as TextView
        city_temperature = findViewById(R.id.City_Temperature) as TextView


    }

    override fun Click(view: View) {
        mPresenter.getWeather(editText!!.text.toString(), getString(R.string.API_Key))
    }

    fun Click1(view: View) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION), 1)

        }


        val locationApiProvider = FusedLocationApiProvider()
        val locationManager = LocationManager(locationApiProvider)
        val locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(1000)

        subscription = locationManager.streamForRequest(this, locationRequest).subscribe(
                { location ->
                    Log.d("Location", location.toString())
                    mPresenter.getWeatherByLocation(location.latitude.toString(), location.longitude.toString(), getString(R.string.API_Key))
                },
                { error ->
                    // Check if the error has solution. Settings or Permission exceptions
                    if (error is LocationConnectionException && error.hasSolution()) {
                        error.startActivityForSolution(this, 1)
                    }
                }
        )


    }

    override fun UpdateCityName(city_name_from_Api: String) {
        city_name!!.text = city_name_from_Api
    }

    override fun UpdateCityTemperature(city_temperature_from_Api: String) {
        city_temperature!!.text = city_temperature_from_Api
    }


}
