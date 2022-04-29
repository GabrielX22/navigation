package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.fragment_firstfragment.*
import kotlinx.android.synthetic.main.fragment_thirdfragment.*


class firstfragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firstfragment, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        webiew.webChromeClient = object : WebChromeClient(){
        }
        webiew.webViewClient = object : WebViewClient(){
        }
        val settings = webiew.settings
        settings.javaScriptEnabled = true
        webiew.loadUrl("https://estudiantes.ugb.edu.sv/Calendarizacion")
    }
}