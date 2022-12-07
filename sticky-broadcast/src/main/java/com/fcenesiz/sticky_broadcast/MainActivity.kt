package com.fcenesiz.sticky_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.fcenesiz.sticky_broadcast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding : ActivityMainBinding

    companion object{
        val TAG: String = MainActivity::class.simpleName.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(activityMainBinding.root)

        activityMainBinding.buttonMethodA.setOnClickListener {
            methodA()
        }
        activityMainBinding.buttonMethodB.setOnClickListener {
            methodB()
        }
    }

    private fun methodA(){
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED)

        val intent = registerReceiver(null, intentFilter)

        if (intent != null) {
            checkBatteryStatus(intent)
        }
    }

    private fun methodB(){
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED)

        registerReceiver(batteryReceiver, intentFilter)
    }

    private val batteryReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
           checkBatteryStatus(intent)
        }
    }

    private fun checkBatteryStatus(intent:Intent){
        val batteryStatus = intent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1)

        when(batteryStatus){
            1 -> Toast.makeText(baseContext, "No Info", Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(baseContext, "Charging", Toast.LENGTH_SHORT).show()
            3 -> Toast.makeText(baseContext, "No Charging", Toast.LENGTH_SHORT).show()
            4 -> Toast.makeText(baseContext, "Plug-out", Toast.LENGTH_SHORT).show()
            5 -> Toast.makeText(baseContext, "Battery is full", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(batteryReceiver)
    }

}