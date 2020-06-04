package com.example.androidweekly.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidweekly.core.Crawling
import com.example.androidweekly.model.WeeklyAndroidDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeFragmentViewModel @Inject constructor() : ViewModel(){
    private val api = Crawling()
    private val _result = MutableLiveData<WeeklyAndroidDataModel>()
    val result : LiveData<WeeklyAndroidDataModel>
        get() = _result


    fun startCrawling(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
               val item = api.getWeeklyData()
                _result.postValue(item)
            }
        }
    }
}