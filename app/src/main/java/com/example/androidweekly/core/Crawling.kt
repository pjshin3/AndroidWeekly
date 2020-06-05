package com.example.androidweekly.core

import android.util.Log
import com.example.androidweekly.difine.WEEKLY_ANDROID_URL
import com.example.androidweekly.model.WeeklyAndroidDataModel
import com.example.androidweekly.model.WeeklyAticle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.w3c.dom.Document

class Crawling {
   suspend fun getWeeklyData() : WeeklyAndroidDataModel{
       val dataModel = WeeklyAndroidDataModel()
       withContext(Dispatchers.IO){
           val doc =  getDocument()

           doc.select(".issue-header img[src]").forEachIndexed { index, element ->
               dataModel.title_url.add(WEEKLY_ANDROID_URL+element.attr("src"))
           }
           dataModel.date = doc.select(".issue-header small").text()
           dataModel.number = doc.select(".issue-header span").text()

           doc.select(".sections a[href]").forEachIndexed { index, element ->
               dataModel.aticle
                   .add(WeeklyAticle(
                       hadline = doc.text(),
                       herf = doc.attr("herf")))
           }
           doc.select(".sections p").forEachIndexed { index, element ->
               Log.e("philip","모델 ${element.text()}")
               dataModel.aticle[index].description = doc.text()
           }
       }
       return dataModel
    }

    private fun getDocument() : org.jsoup.nodes.Document =
        Jsoup.connect(WEEKLY_ANDROID_URL)
            .userAgent("Mozilla")
            .get()
}