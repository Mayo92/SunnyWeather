package com.yly.sunnyweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather.logic.network
 * 文件名： ServiceCreator
 * 创建者： YLY
 * 时 间：  2020-05-02 17:06
 * 描 述：  TODO
 */
object ServiceCreator {

    private const val BASE_URL = "https://api.caiyunapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>):T = retrofit.create(serviceClass)

    inline fun <reified T> create() : T = create(T::class.java)
}