package com.example.broadcast_types;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ReceiverD  extends BroadcastReceiver {
    public static final String TAG = ReceiverA.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        usage2();
        Toast.makeText(context, ReceiverA.class.getSimpleName() + " was called", Toast.LENGTH_SHORT).show();
    }

    private void usage2(){
        if (!isOrderedBroadcast()) return;

        int code = getResultCode();
        String data = getResultData();
        Bundle bundle = getResultExtras(true);
        String breath_state = bundle.getString("breath_state");

        String log = "code: " + code + ", result_data: " + data + ", breath_state: " + breath_state;
        Log.i(TAG, log);

    }
}