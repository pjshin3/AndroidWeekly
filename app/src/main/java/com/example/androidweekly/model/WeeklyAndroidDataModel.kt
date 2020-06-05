package com.example.androidweekly.model

data class WeeklyAndroidDataModel(
    var date : String = "",
    var number : String = "",
    var title_url : ArrayList<String> = arrayListOf(),
    var aticle: ArrayList<WeeklyAticle> = arrayListOf()
)


data class WeeklyAticle(
    var hadline : String = "",
    var description : String = "",
    var herf : String = "",
    var imageurl : String = ""
)