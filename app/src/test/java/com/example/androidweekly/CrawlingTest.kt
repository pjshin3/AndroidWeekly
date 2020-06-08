package com.example.androidweekly

import com.example.androidweekly.core.Crawling
import com.example.androidweekly.model.WeeklyAndroidDataModel
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CrawlingTest {
    lateinit var crawling : Crawling
    @Before
    fun setUp(){
        crawling = Crawling()
    }

    @Test
    fun `TEST WEEKLY NUMBER`(){
        val result = runBlocking { crawling.getWeeklyData().number }
        assertEquals("#417",result)
    }

    @Test
    fun `TEST WEEKLY DATE`(){
        val result = runBlocking { crawling.getWeeklyData().date }
        println(result)
        assertEquals("June 7th, 2020",result)
    }

    @Test
    fun `TEST WEEKLY ATICLE SIZE`(){
        val result = runBlocking { crawling.getWeeklyData().aticle.size }
        println(result)
        assertEquals(25,result)
    }

}