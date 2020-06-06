package com.example.androidweekly.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.observe
import com.example.androidweekly.R
import com.example.androidweekly.adapter.HomeAticleAdapter
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

        val aticleAdapter = HomeAticleAdapter()

        binding.hasList = false
        binding.aticleRecyclerview.adapter = aticleAdapter
        binding.loadingAnimation.setAnimation("aticle_loading.json")


        vm.result.observe(viewLifecycleOwner){
            binding.hasList = true
            aticleAdapter.submitList(it.aticle)
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