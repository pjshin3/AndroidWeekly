package com.example.androidweekly.ui

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.androidweekly.R
import com.example.androidweekly.databinding.FragmentSplashBinding
import kotlinx.coroutines.*

class SplashFragment() : BaseFragment<FragmentSplashBinding> (
    viewId = R.layout.fragment_splash
){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lottie.setAnimation("splash.json")
        MainScope().launch {
            delay(3500)
            withContext(Dispatchers.Main){
                findNavController().navigate(SplashFragmentDirections.actionSplashToHome())
            }
        }
    }
}