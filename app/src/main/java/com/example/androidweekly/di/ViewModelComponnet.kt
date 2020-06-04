package com.example.androidweekly.di

import com.example.androidweekly.viewmodel.HomeFragmentViewModel
import dagger.Component

@Component(modules = [HomeFragmentViewModelModule::class])
interface ViewModelComponnet {
    fun getHomeFragmentViewModel() : HomeFragmentViewModel
}