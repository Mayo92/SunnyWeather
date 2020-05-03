package com.yly.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather.logic.model
 * 文件名： RealtimeResponse
 * 创建者： YLY
 * 时 间：  2020-05-02 21:51
 * 描 述：  TODO
 */
data class RealtimeResponse(val status: String,val result: Result){

    data class Result(val realtime: Realtime)

    data class Realtime(val skycon: String,val temperature: Float,
                        @SerializedName("air_quality") val airQuality: AirQuality)

    data class AirQuality(val aqi: AQI)

    data class AQI(val chn: Float)
}