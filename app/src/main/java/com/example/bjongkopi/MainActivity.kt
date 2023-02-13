package com.example.bjongkopi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.ui.setupWithNavController
import com.example.bjongkopi.fragment.AkunFragment
import com.example.bjongkopi.fragment.HomeFragment
import com.example.bjongkopi.fragment.KeranjangFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val fragmentHome : Fragment = HomeFragment()
    val fragmentkeranjang : Fragment = KeranjangFragment()
    val fragmentakun : Fragment = AkunFragment()
    val fm : FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome

    private lateinit var menu : Menu
    private lateinit var menuItem :MenuItem
    private lateinit var bottomNavigationView :BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBottomNav()
    }

    fun setBottomNav(){
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentkeranjang).hide(fragmentkeranjang).commit()
        fm.beginTransaction().add(R.id.container, fragmentakun).hide(fragmentakun).commit()

        bottomNavigationView = findViewById(R.id.nav_view)

        menu = bottomNavigationView.menu

        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigation_home->{
                    Log.d("Response", "Home")
                    callFragment(0, fragmentHome)
                }
                R.id.navigation_keranjang->{
                    Log.d("Response", "keranjang")
                    callFragment(1, fragmentkeranjang)
                }
                R.id.navigation_akun->{
                    Log.d("Response", "Akun")
                    callFragment(2, fragmentakun)
                }
            }
            false
        }
    }
    fun callFragment(int : Int, fragment: Fragment){
        Log.d("Response", "Akun")
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}