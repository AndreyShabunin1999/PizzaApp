package com.example.pizzaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.pizzaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binging: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binging.root)
        replaceFragment(Menu())

        binging.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.id_menu -> replaceFragment(Menu())
                R.id.id_profile -> replaceFragment(Profile())
                R.id.id_shopping_basket -> replaceFragment(Shopping_basket())

                else->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransction = fragmentManager.beginTransaction()
        fragmentTransction.replace(R.id.frame_layout, fragment)
        fragmentTransction.addToBackStack(null)
        fragmentTransction.commit()
    }
}