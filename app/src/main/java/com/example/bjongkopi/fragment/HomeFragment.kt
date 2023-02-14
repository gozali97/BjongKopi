package com.example.bjongkopi.fragment

import android.os.Bundle
import android.content.Intent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.bjongkopi.R
import com.example.bjongkopi.adapter.AdapterProduk
import com.example.bjongkopi.app.ApiConfig
import com.example.bjongkopi.model.Produk
import com.example.bjongkopi.model.ResponModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class HomeFragment : Fragment() {

    lateinit var rvProduk: RecyclerView
    lateinit var rvProdukTerlasir: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        getProduk()
    }

    fun displayProduk() {
        Log.d("listdisplay", "display")

        rvProduk.adapter = AdapterProduk(requireActivity(), listProduk)

        rvProdukTerlasir.adapter = AdapterProduk(requireActivity(), listProduk)

    }

    private var listProduk: List<Produk> = listOf()
    fun getProduk() {
        Log.d("listproduk", "failedss")
        ApiConfig.instanceRetrofit.getProduk().enqueue(object : Callback<List<Produk>> {
            override fun onFailure(call: Call<List<Produk>>, t: Throwable) {
                Log.d("listproduk", "failed" + t.message)
            }

            override fun onResponse(call: Call<List<Produk>>, response: Response<List<Produk>>) {
                Log.d("listproduk", "produk" + response)
                val res = response.body()!!
//                res.forEach {
//                    if (res.success == 1) {
                        listProduk = res
                    Log.d("listproduk", "produk" + res)

                        displayProduk()
//                    }else{
//                    Log.d("gagal", "gagal boss")
//                }
//                }
            }
        })
    }

    fun init(view: View) {
        Log.d("listInit", "inittttt")
        rvProduk = view.findViewById(R.id.rv_produk)
        rvProdukTerlasir = view.findViewById(R.id.rv_produkTerlasir)

//        rvProduk.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(activity, 2)
        layoutManager.orientation = GridLayoutManager.HORIZONTAL

        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

//        rvProduk.adapter = AdapterProduk(requireActivity(), listProduk)
        rvProduk.layoutManager = layoutManager

//        rvProdukTerlasir.adapter = AdapterProduk(requireActivity(), listProduk)
        rvProdukTerlasir.layoutManager = layoutManager2
    }
}