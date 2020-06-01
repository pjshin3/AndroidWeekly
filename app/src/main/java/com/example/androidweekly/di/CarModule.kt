package com.example.androidweekly.di

import dagger.Module
import dagger.Provides

@Module
class   CarModule {
    @Provides
    fun provideCarEngine(part : PartA) : CarEngine{
        return CarEngine(part)
    }
    @Provides
    fun providePartA(partB: PartB) : PartA{
        return PartA(partB)
    }
    @Provides
    fun providePartB(): PartB{
        return PartB()
    }
}