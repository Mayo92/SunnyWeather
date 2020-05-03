package com.yly.sunnyweather.logic.network

import com.yly.sunnyweather.MyApplication
import com.yly.sunnyweather.logic.model.DailyResponse
import com.yly.sunnyweather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather.logic.network
 * 文件名： WeatherService
 * 创建者： YLY
 * 时 间：  2020-05-02 22:11
 * 描 述：  TODO
 */
interface WeatherService {

    @GET("v2.5/${MyApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng")lng: String,@Path("lat")lat: String):
            Call<RealtimeResponse>

    @GET("v2.5/${MyApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng")lng: String,@Path("lat")lat: String):
            Call<DailyResponse>
}