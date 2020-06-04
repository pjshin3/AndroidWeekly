package com.example.androidweekly.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import com.example.androidweekly.R
import com.example.androidweekly.databinding.FragmentHomeBinding
import com.example.androidweekly.di.DaggerViewModelComponnet
import com.example.androidweekly.di.HomeFragmentViewModelModule
import com.example.androidweekly.viewmodel.HomeFragmentViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(
    viewId = R.layout.fragment_home
){
    lateinit var vm : HomeFragmentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injectComponnet()
        vm.startCrawling()

        binding.hasList = false

        vm.result.observe(viewLifecycleOwner){
            binding.hasList = true
            binding.model = it
        }
    }

    private fun injectComponnet(){
        vm = DaggerViewModelComponnet.builder()
            .homeFragmentViewModelModule(HomeFragmentViewModelModule())
            .build()
            .getHomeFragmentViewModel()
    }
}