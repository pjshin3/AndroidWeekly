package com.example.androidweekly

import android.content.Context
import com.example.androidweekly.di.Car
import com.example.androidweekly.di.CarModule
import com.example.androidweekly.di.ContextModule
import com.example.androidweekly.di.DaggerCarComponnet
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock

class CarTest {

    private lateinit var car : Car

    private var context: Context = mock(Context::class.java)
    @Test
    fun carNameTest(){
        injectionCar()
        assertEquals("BMW320iM",car.myCarName())
    }
    fun injectionCar(){
        car = DaggerCarComponnet.builder()
            .carModule(CarModule())
            .contextModule(ContextModule(context))
            .build()
            .getCar()
    }
}