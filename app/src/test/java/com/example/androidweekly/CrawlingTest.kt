package com.example.androidweekly

import com.example.androidweekly.core.Crawling
import com.example.androidweekly.model.WeeklyAndroidDataModel
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test

class CrawlingTest {
    lateinit var crawling : Crawling
    @Before
    fun setUp(){
        crawling = Crawling()
    }
    @Test
    fun `test Title Img Url`(){
        var compara : WeeklyAndroidDataModel
        CoroutineScope(Dispatchers.IO).launch {
            compara = crawling.getWeeklyData()

            assertEquals("#416",compara.number)
        }
    }


}