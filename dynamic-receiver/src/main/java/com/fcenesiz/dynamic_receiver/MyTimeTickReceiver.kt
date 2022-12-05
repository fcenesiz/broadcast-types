package com.fcenesiz.dynamic_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.fcenesiz.dynamic_receiver.databinding.ActivityMainBinding

class MyTimeTickReceiver(val activityMainBinding: ActivityMainBinding) : BroadcastReceiver() {

    var tick: Int = 0

    companion object{
        public val TAG: String = MyTimeTickReceiver::class.simpleName.toString()
    }

    override fun onReceive(p0: Context?, p1: Intent?) {

        activityMainBinding.textViewTick.text = (++tick).toString()

        Log.i(TAG, "received!")
        Toast.makeText(p0, "received", Toast.LENGTH_SHORT).show()
    }

}