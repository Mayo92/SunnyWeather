package com.yly.sunnyweather.logic

import androidx.lifecycle.liveData
import com.yly.sunnyweather.logic.dao.PlaceDao
import com.yly.sunnyweather.logic.model.Place
import com.yly.sunnyweather.logic.model.Weather
import com.yly.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather.logic
 * 文件名： Repository
 * 创建者： YLY
 * 时 间：  2020-05-02 17:24
 * 描 述：  TODO
 */
object Repository {

    fun searchPlaces(query:String) = fire(Dispatchers.IO){
//        val result = try {
//            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
//            if(placeResponse.status == "ok"){
//                val places = placeResponse.places
//                Result.success(places)
//            }else{
//                Result.failure(
//                    RuntimeException("response status is ${placeResponse.status}"))
//            }
//        } catch (e:Exception){
//            Result.failure<List<Place>>(e)
//        }
//        emit(result)


        val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
        if(placeResponse.status == "ok"){
            val places = placeResponse.places
            Result.success(places)
        }else{
            Result.failure(
                RuntimeException("response status is ${placeResponse.status}"))
        }
    }

    fun refreshWeather(lng: String,lat: String) = fire(Dispatchers.IO) {
//        val result = try {
//            coroutineScope{
//                val deferredRealtime = async {
//                    SunnyWeatherNetwork.getRealtimeWeather(lng,lat)
//                }
//                val deferredDaily = async {
//                    SunnyWeatherNetwork.getDailyWeather(lng,lat)
//                }
//                val realtimeResponse = deferredRealtime.await()
//                val dailyResponse = deferredDaily.await()
//
//                if(realtimeResponse.status == "ok" && dailyResponse.status == "ok"){
//                    val weather = Weather(realtimeResponse.result.realtime,
//                        dailyResponse.result.daily)
//                    Result.success(weather)
//                }else {
//                    Result.failure(
//                        RuntimeException("realtimeResponse status is ${realtimeResponse.status}" +
//                                "dailyResponse status is ${dailyResponse.status}"))
//                }
//            }
//
//        } catch (e: Exception) {
//            Result.failure<Weather>(e)
//        }
//        emit(result)

        coroutineScope{
            val deferredRealtime = async {
                SunnyWeatherNetwork.getRealtimeWeather(lng,lat)
            }
            val deferredDaily = async {
                SunnyWeatherNetwork.getDailyWeather(lng,lat)
            }
            val realtimeResponse = deferredRealtime.await()
            val dailyResponse = deferredDaily.await()

            if(realtimeResponse.status == "ok" && dailyResponse.status == "ok"){
                val weather = Weather(realtimeResponse.result.realtime,
                    dailyResponse.result.daily)
                Result.success(weather)
            }else {
                Result.failure(
                    RuntimeException("realtimeResponse status is ${realtimeResponse.status}" +
                            "dailyResponse status is ${dailyResponse.status}"))
            }
        }
    }

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }

    fun savePlace(place:Place) = PlaceDao.savePlace(place)

    fun getSavedPlace() = PlaceDao.getSavedPlace()

    fun isPlaceSaved() = PlaceDao.isPlaceSaved()
}