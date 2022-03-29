package com.example.gif.DataClasses

import com.google.gson.annotations.SerializedName

data class Gif(@SerializedName("data")val result:ArrayList<Data>)

data class Data(@SerializedName("images") val images:Originals)

data class Originals(@SerializedName("original")val image:SingleImage)

data class SingleImage(@SerializedName("url")val urlImage:String)




