package com.fcenesiz.local_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val x = intent?.getIntExtra("x", 0)
        val y = intent?.getIntExtra("y", 0)
        val sum = x!! + y!!

        val localBroadcastManager = LocalBroadcastManager.getInstance(context!!)

        val returning = Intent("my.result.receiver.action")
        returning.putExtra("sum", sum)
        localBroadcastManager.sendBroadcast(returning)
    }
}