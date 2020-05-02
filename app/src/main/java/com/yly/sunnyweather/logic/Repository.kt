package com.yly.sunnyweather.logic

import androidx.lifecycle.liveData
import com.yly.sunnyweather.logic.model.Place
import com.yly.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather.logic
 * 文件名： Repository
 * 创建者： YLY
 * 时 间：  2020-05-02 17:24
 * 描 述：  TODO
 */
object Repository {

    fun searchPlaces(query:String) = liveData(Dispatchers.IO){
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if(placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(
                    RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}