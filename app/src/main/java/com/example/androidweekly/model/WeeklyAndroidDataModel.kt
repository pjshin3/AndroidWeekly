package com.example.androidweekly.model

data class WeeklyAndroidDataModel(
    var date : String = "",
    var number : String = "",
    var title_url : ArrayList<String> = arrayListOf()
)