package com.yly.sunnyweather.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.yly.sunnyweather.MyApplication
import com.yly.sunnyweather.logic.model.Place

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather.logic.dao
 * 文件名： PlaceDao
 * 创建者： YLY
 * 时 间：  2020-05-03 18:01
 * 描 述：  TODO
 */
object PlaceDao {

    fun savePlace(place:Place){
        sharedPreferences().edit{
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavedPlace():Place {
        val placeJson = sharedPreferences().getString("place","")
        return Gson().fromJson(placeJson,Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() = MyApplication.context.
            getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}