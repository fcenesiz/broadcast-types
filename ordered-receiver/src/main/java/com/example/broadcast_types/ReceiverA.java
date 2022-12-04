package com.example.broadcast_types;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ReceiverA extends BroadcastReceiver {
    public static final String TAG = ReceiverA.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        usage2();
        Toast.makeText(context, ReceiverA.class.getSimpleName() + " was called", Toast.LENGTH_SHORT).show();
    }

    private void usage2(){
        int code = getResultCode();
        String data = getResultData();
        Bundle bundle = getResultExtras(true);
        String weather = bundle.getString("weather");

        String log = "code: " + code + ", result_data: " + data + ", weather: " + weather;
        Log.i(TAG, log);
    }
}
