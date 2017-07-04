package com.yaskiv.retrofit_weather.Services

import android.Manifest
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.location.LocationManager
import android.content.ContentValues.TAG
import android.content.pm.PackageManager
import android.Manifest.permission
import android.Manifest.permission.ACCESS_COARSE_LOCATION
import com.yaskiv.retrofit_weather.View.Impl.MainActivity
import android.support.v4.app.ActivityCompat
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import android.util.Log


class LocationService : Service(), LocationListener {
    var imHere: Location? = null
    var locationManager: LocationManager? = null

    override fun onCreate() {
        LocationManagerWork()
        super.onCreate()


    }

    override fun onLocationChanged(p0: Location?) {
        Log.d("Location", p0.toString())
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBind(intent: Intent): IBinder? {
        LocationManagerWork()
        throw UnsupportedOperationException("Not yet implemented")
    }

    @SuppressLint("MissingPermission")
    fun LocationManagerWork() {

        locationManager = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val locationListener = LocationService()
        var k: Float = 0F
        locationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, k, locationListener);

        imHere = locationManager!!.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        Log.d("Location", imHere.toString())
        if (imHere != null) {
            Log.d("Location", imHere.toString())
        } else {
            Log.d("Location", "Dont have loc")
        }
    }
}
