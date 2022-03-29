package com.example.gif.Retrofit

import com.example.gif.DataClasses.Gif

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ResponseApi {
    @GET("./trending")
    fun getGif(@Query("api_key") apiKey: String):Call<Gif>
    @GET("./search?")
  fun  gifSearch(@Query("api_key") apiKey:String,
                   @Query("q") q:String,
                   @Query("lang") lung:String):Call<Gif>

}