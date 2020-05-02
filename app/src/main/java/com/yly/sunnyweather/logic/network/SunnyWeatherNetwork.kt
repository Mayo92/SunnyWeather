package com.yly.sunnyweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather.logic.network
 * 文件名： SunnyWeatherNetwork
 * 创建者： YLY
 * 时 间：  2020-05-02 17:12
 * 描 述：  TODO
 */
object SunnyWeatherNetwork {

    private val placeService = ServiceCreator.create(PlaceService::class.java)

    suspend fun searchPlaces(query:String) = placeService.searchPlaces(query).await()

    private suspend fun <T> Call<T>.await():T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T>{
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}