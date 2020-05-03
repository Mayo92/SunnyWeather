package com.yly.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName
import java.util.*

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather.logic.model
 * 文件名： DailyResponse
 * 创建者： YLY
 * 时 间：  2020-05-02 21:59
 * 描 述：  TODO
 */
data class DailyResponse(val status: String,val result: Result){

    data class Result(val daily: Daily)

    data class Daily(val temperature: List<Temperature>,val skycon: List<Skycon>,
                     @SerializedName("life_index")val lifeIndex: LifeIndex)

    data class Temperature(val max: Float,val min: Float)

    data class Skycon(val value: String,val date: Date)

    data class LifeIndex(val coldRisk: List<LifeDescription>,
                         val carWashing: List<LifeDescription>,
                         val ultraviolet: List<LifeDescription>,
                         val dressing: List<LifeDescription>)

    data class LifeDescription(val desc: String)
}