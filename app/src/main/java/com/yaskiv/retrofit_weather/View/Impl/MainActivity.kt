package com.yaskiv.retrofit_weather.View.Impl


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.yaskiv.retrofit_weather.Model.City.c_City
import com.yaskiv.retrofit_weather.Model.Weather.w_Wind
import com.yaskiv.retrofit_weather.Presenter.MainActivityPresenter
import com.yaskiv.retrofit_weather.R
import com.yaskiv.retrofit_weather.View.IMainActivity
import io.realm.Realm



class MainActivity : AppCompatActivity(), IMainActivity {

    var editText: EditText? = null
    var city_name: TextView? = null

    override fun onStop() {
        super.onStop()
        mPresenter.unsubscribe()
    }

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

    override fun Click1(view: View) {
        mPresenter.CheckPermissions(this, this)

        mPresenter.getLocation(this, getString(R.string.API_Key), 1)


    }

    override fun Click2(view: View) {
        mPresenter.CheckPermissions(this, this)

        mPresenter.getLocation(this, getString(R.string.API_Key), 2)
    }

    override fun Click3(view: View) {
        Realm.init(this)
        val realm = Realm.getDefaultInstance()
        try {
            var events: List<w_Wind> = realm.where(w_Wind::class.java).findAll()
            for (kl in events) {
                Log.d("Realm", kl.deg.toString())
            }
        } finally {
            realm.close()
        }

    }

    override fun UpdateCityName(city_name_from_Api: String) {
        city_name!!.text = city_name_from_Api

    }

    override fun UpdateCityTemperature(city_temperature_from_Api: String) {
        city_temperature!!.text = city_temperature_from_Api
    }

    override fun Click_City(view: View) {
        mPresenter.getCity()
    }

    override fun Click_Realm(view: View) {
        mPresenter.get_list(this)
    }

    override fun Click_Get_City(view: View) {
        Realm.init(this)
        val realm = Realm.getDefaultInstance()
        try {
            var events: List<c_City> = realm.where(c_City::class.java).findAll()
            for (kl in events) {
                Log.d("Realm", kl.name.toString())
            }
        } finally {
            realm.close()
        }
    }
}
