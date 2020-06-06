package com.example.androidweekly.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.androidweekly.R
import com.example.androidweekly.databinding.FragmentSplashBinding
import kotlinx.coroutines.*

class SplashFragment() : BaseFragment<FragmentSplashBinding> (
    viewId = R.layout.fragment_splash
){
    private val scope =  CoroutineScope(Dispatchers.Main)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lottie.setAnimation("splash.json")
        scope.launch {
            delay(3500)
            findNavController().navigate(R.id.action_splash_to_home)
        }
    }
}