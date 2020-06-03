package com.example.androidweekly.core

import android.util.Log
import com.example.androidweekly.difine.WEEKLY_ANDROID_URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class Crawling {
   suspend fun getWeeklyData(){
       withContext(Dispatchers.IO){
           val itemList = ArrayList<String>()
           val doc = Jsoup.connect(WEEKLY_ANDROID_URL)
               .userAgent("Mozilla")
               .get()
               .select(".issue-header img[src]")


           for ((index, element ) in doc.withIndex()){
               Log.e("philip","아이템 = $element")
           }
       }
    }
}