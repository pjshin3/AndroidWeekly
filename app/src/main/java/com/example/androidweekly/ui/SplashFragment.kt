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
    private val scope =  CoroutineScope(Dispatchers.Main)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lottie.setAnimation("splash.json")
        Handler().postDelayed(Runnable {
            findNavController().popBackStack()
            val directions = SplashFragmentDirections.actionSplashToHome()
            this.findNavController().navigate(directions)
        },3000)
    }
}