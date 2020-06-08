package com.example.androidweekly.ui

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.activity.addCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.observe
import com.example.androidweekly.R
import com.example.androidweekly.adapter.HomeAticleAdapter
import com.example.androidweekly.databinding.FragmentHomeBinding
import com.example.androidweekly.di.DaggerViewModelComponnet
import com.example.androidweekly.di.HomeFragmentViewModelModule
import com.example.androidweekly.viewmodel.HomeFragmentViewModel
import kotlinx.android.synthetic.main.fragment_home.*

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
        lottie.setAnimation("navigation_menu.json")
        lottie.setOnClickListener {
            lottie.playAnimation()
            drawer.openDrawer(GravityCompat.START)
        }

        requireActivity().onBackPressedDispatcher.addCallback {
        }
    }

    private fun injectComponnet(){
        vm = DaggerViewModelComponnet.builder()
            .homeFragmentViewModelModule(HomeFragmentViewModelModule())
            .build()
            .getHomeFragmentViewModel()
    }
}