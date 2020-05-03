package com.yly.sunnyweather.logic.model

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather.logic.model
 * 文件名： Weather
 * 创建者： YLY
 * 时 间：  2020-05-02 22:09
 * 描 述：  TODO
 */
data class Weather(val realtime: RealtimeResponse.Realtime,
                   val daily: DailyResponse.Daily)