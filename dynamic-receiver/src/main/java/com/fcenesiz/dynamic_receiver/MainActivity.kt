package com.fcenesiz.dynamic_receiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fcenesiz.dynamic_receiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var myTimeTickReceiver: MyTimeTickReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myTimeTickReceiver = MyTimeTickReceiver(binding)

    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_TIME_TICK)
        registerReceiver(myTimeTickReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(myTimeTickReceiver)
    }
}