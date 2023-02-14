package com.example.bjongkopi.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap.Config
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.bjongkopi.R
import com.example.bjongkopi.helper.Helper
import com.example.bjongkopi.model.Produk
import com.google.gson.Gson

import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class AdapterProduk(var activity: Activity, var data: List<Produk>) : RecyclerView.Adapter<AdapterProduk.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
        val tvHarga = view.findViewById<TextView>(R.id.tv_harga)
        val tvKet = view.findViewById<TextView>(R.id.tv_ket)
        val imgProduk = view.findViewById<ImageView>(R.id.img_produk)
        val layout = view.findViewById<CardView>(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val a = data[position]

        Log.d("Data", "Nama Produk: " + data[position].nama_produk)
        Log.d("Data", "Harga: " + data[position].harga)
        Log.d("Data", "Keterangan: " + data[position].keterangan)
        Log.d("Data", "Image URL: " + data[position].image_url)


        var harga = Integer.valueOf(a.harga)


        holder.tvHarga.text = Helper().gantiRupiah(harga)
        holder.tvNama.text = data[position].nama_produk
        holder.tvKet.text = data[position].keterangan

        val image = data[position].image_url
        Picasso.get()
            .load(image)
            .placeholder(R.drawable.sample)
            .error(R.drawable.sample)
            .into(holder.imgProduk)

    }

}