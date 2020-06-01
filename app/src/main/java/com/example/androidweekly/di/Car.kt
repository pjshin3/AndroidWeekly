package com.example.androidweekly.di

import android.content.Context
import javax.inject.Inject

class Car @Inject constructor(var engine: CarEngine,val context: Context)
class CarEngine(private var partA: PartA)
class PartA(private var partB: PartB)
class PartB