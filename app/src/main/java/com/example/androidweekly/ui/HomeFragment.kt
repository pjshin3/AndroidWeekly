package com.example.androidweekly.ui

import android.os.Bundle
import android.view.View
import com.example.androidweekly.R
import com.example.androidweekly.core.Crawling
import com.example.androidweekly.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding>(
    viewId = R.layout.fragment_home
){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tmep = Crawling()
        CoroutineScope(Dispatchers.IO).launch {
            tmep.getWeeklyData()
        }
    }
}