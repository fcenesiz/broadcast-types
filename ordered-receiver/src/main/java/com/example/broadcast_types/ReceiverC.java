package com.example.broadcast_types;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiverC  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, ReceiverC.class.getSimpleName() + " was called", Toast.LENGTH_SHORT).show();
    }
}