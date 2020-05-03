package com.yly.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather
 * 文件名： MyApplication
 * 创建者： YLY
 * 时 间：  2020-05-02 16:53
 * 描 述：  TODO
 */
class MyApplication : Application() {

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN = "sFnjrbRdi0dxUFl3"//彩云token
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}