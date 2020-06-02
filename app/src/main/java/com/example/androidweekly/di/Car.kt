package com.example.androidweekly.di

import android.content.Context
import javax.inject.Inject

class Car @Inject constructor(var engine: CarEngine,val context: Context){
    fun myCarName() : String{
//        println("내 자동차 이름은 = $context")
        return "BMW320iM"
    }
}
class CarEngine(private var partA: PartA)
class PartA(private var partB: PartB)
class PartB