package com.example.gif

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gif.DataClasses.Data
import com.example.gif.DataClasses.Gif
import com.example.gif.Retrofit.RetrofitConnect
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel:ViewModel() {
    val liveData=MutableLiveData<ArrayList<Data>>()
    private val apiKey="UwugRXAivTQRXo0546UcGlPqZYrqLjaf"
    val response = RetrofitConnect().create()
    init {


            response?.getGif(apiKey)?.enqueue(object : Callback<Gif> {
                override fun onResponse(call: Call<Gif>, response: Response<Gif>) {
                    if (response.isSuccessful) {
                        val body = response.body()
                        if (body != null)
                            liveData.value = body.result
                    }
                }

                override fun onFailure(call: Call<Gif>, t: Throwable) {
                    t.printStackTrace()
                }
            })

    }

     fun search(text: String) {


             response?.gifSearch(apiKey, text, "ru")?.enqueue(object : Callback<Gif> {
                 override fun onResponse(call: Call<Gif>, response: Response<Gif>) {
                     if (response.isSuccessful) {
                         val body = response.body()
                         if (body != null)
                             liveData.postValue(body.result)
                     }
                 }
                 override fun onFailure(call: Call<Gif>, t: Throwable) {
                     t.printStackTrace()
                 }
             })

     }

}