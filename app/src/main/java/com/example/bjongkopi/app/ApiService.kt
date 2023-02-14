package com.example.bjongkopi.app

import com.example.bjongkopi.model.Produk
import com.example.bjongkopi.model.ResponModel
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("produk/getproduk")
    fun getProduk(): Call<List<Produk>>

}
