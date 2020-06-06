package com.example.androidweekly.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidweekly.R
import com.example.androidweekly.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailWebViewFragment : BaseFragment<FragmentDetailBinding>(
    viewId = R.layout.fragment_detail
){
    private val arg : DetailWebViewFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webViewClient = WebViewClient()
        webViewClient.onPageFinished(web,arg.url)

        with(binding){
            lottie.setAnimation("aticle_loading.json")
            web.loadUrl(arg.url)
            web.webViewClient = object : WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    isLoding = true
                }
            }
            toolbar.title = getString(R.string.fragment_detail)
        }
        setHasOptionsMenu(true)
        (context as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (context as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                findNavController().popBackStack()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}