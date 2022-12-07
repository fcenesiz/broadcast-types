package com.fcenesiz.local_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.fcenesiz.local_receiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var localBroadcastManager: LocalBroadcastManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        localBroadcastManager = LocalBroadcastManager.getInstance(this)
        binding.buttonSendBroadcast.setOnClickListener {
            sendBroadcast()
        }
    }

    private fun sendBroadcast(){
        val intent = Intent(this, MyReceiver::class.java)
        intent.putExtra("x", 15)
        intent.putExtra("y", 20)
        sendBroadcast(intent)
    }

    private val returnReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            val sum = intent!!.getIntExtra("sum", 0)
            Toast.makeText(baseContext, "sum: $sum", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter("my.result.receiver.action")
        localBroadcastManager.registerReceiver(returnReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(returnReceiver)
    }

}