package com.example.androidweekly.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.androidweekly.R
import com.example.androidweekly.databinding.FragmentSplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment() : BaseFragment<FragmentSplashBinding> (
    viewId = R.layout.fragment_splash
){
    private val scope =  CoroutineScope(Dispatchers.Main)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scope.launch {
            delay(2000)
            findNavController().navigate(R.id.action_splash_to_home)
        }
    }
}