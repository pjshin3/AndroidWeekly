package com.example.androidweekly.di

import dagger.Component

@Component(modules = [CarModule::class, ContextModule::class])
interface CarComponnet {
    fun getCar() : Car
}