package com.yly.sunnyweather.logic.network

import com.yly.sunnyweather.MyApplication
import com.yly.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather.logic.network
 * 文件名： PlaceService
 * 创建者： YLY
 * 时 间：  2020-05-02 17:02
 * 描 述：  TODO
 */
interface PlaceService {

    @GET("v2/place?token=${MyApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query")query: String):Call<PlaceResponse>
}