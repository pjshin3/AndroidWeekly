package com.example.androidweekly.di

import com.example.androidweekly.viewmodel.HomeFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentViewModelModule{
    @Provides
    fun provideHomeViewModel() = HomeFragmentViewModel()
}