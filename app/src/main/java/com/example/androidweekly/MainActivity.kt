package com.example.androidweekly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidweekly.di.Car
import com.example.androidweekly.di.CarModule
import com.example.androidweekly.di.ContextModule
import com.example.androidweekly.di.DaggerCarComponnet

class MainActivity : AppCompatActivity() {

    private lateinit var car : Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectComponnet()
    }

    private fun injectComponnet(){
        car = DaggerCarComponnet.builder()
            .carModule(CarModule())
            .contextModule(ContextModule(this))
            .build()
            .getCar()
    }

}
