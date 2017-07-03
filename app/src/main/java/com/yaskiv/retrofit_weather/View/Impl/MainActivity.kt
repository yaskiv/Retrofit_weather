package com.yaskiv.retrofit_weather.View.Impl

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

class MainActivity : AppCompatActivity(), IMainActivity {
    var editText: EditText? = null
    var city_name: TextView? = null
    var city_temperature: TextView? = null
    val mPresenter = MainActivityPresenter(this)
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

    override fun UpdateCityName(city_name_from_Api: String) {
        city_name!!.text = city_name_from_Api
    }

    override fun UpdateCityTemperature(city_temperature_from_Api: String) {
        city_temperature!!.text = city_temperature_from_Api
    }
}
