package com.yly.sunnyweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yly.sunnyweather.logic.Repository
import com.yly.sunnyweather.logic.model.Location

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather.ui.weather
 * 文件名： WeatherViewModel
 * 创建者： YLY
 * 时 间：  2020-05-03 15:11
 * 描 述：  TODO
 */
class WeatherViewModel : ViewModel() {

    private val locationLiveData = MutableLiveData<Location>()

    var locationLng = ""

    var locationLat = ""

    var placeName = ""

    val weatherLiveData = Transformations.switchMap(locationLiveData){location->
        Repository.refreshWeather(location.lng,location.lat)
    }

    fun refreshWeather(lng:String,lat:String){
        locationLiveData.value = Location(lng,lat)
    }
}