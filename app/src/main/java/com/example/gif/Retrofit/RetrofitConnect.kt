package com.example.gif.Retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConnect {
    private val URL: String = "https://api.giphy.com/v1/gifs/"
    private fun Retrofit(): Retrofit {
        val log = HttpLoggingInterceptor()
        log.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(log).build()
        return Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient).build()
    }
    fun create(): ResponseApi? {
        return Retrofit().create(ResponseApi::class.java)
    }
}