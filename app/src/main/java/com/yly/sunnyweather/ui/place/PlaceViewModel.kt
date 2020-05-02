package com.yly.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yly.sunnyweather.logic.Repository
import com.yly.sunnyweather.logic.model.Place
import java.util.*

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather.ui.place
 * 文件名： PlaceViewModel
 * 创建者： YLY
 * 时 间：  2020-05-02 17:39
 * 描 述：  TODO
 */
class PlaceViewModel : ViewModel(){

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData){query->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query:String){
        searchLiveData.value = query
    }
}