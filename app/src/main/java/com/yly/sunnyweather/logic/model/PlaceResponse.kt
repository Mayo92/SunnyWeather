package com.yly.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/*
 * 项目名： SunnyWeather
 * 包 名：  com.yly.sunnyweather.logic.model
 * 文件名： PlaceResponse
 * 创建者： YLY
 * 时 间：  2020-05-02 16:56
 * 描 述：  TODO
 */
data class PlaceResponse(val status:String,val places:List<Place>)

data class Place(val name:String, val location: Location,
                 @SerializedName("formatted_address")val address:String)

data class Location(val lng:String,val lat:String)