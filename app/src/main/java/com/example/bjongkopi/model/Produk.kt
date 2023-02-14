package com.example.bjongkopi.model

import com.google.gson.annotations.SerializedName

data class Produk (
    @SerializedName("id_produk")
    var id_produk: Int,
    @SerializedName("nama_produk")
    var nama_produk: String? = null,
    @SerializedName("harga")
    var harga: String? = null,
    @SerializedName("keterangan")
    var keterangan: String? = null,
    @SerializedName("gambar")
    var gambar: String? = null,
    @SerializedName("image_url")
    var image_url: String? = null,
)