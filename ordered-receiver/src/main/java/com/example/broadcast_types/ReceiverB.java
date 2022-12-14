package com.example.broadcast_types;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ReceiverB  extends BroadcastReceiver {

    public static final String TAG = ReceiverB.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        usage2();
        Toast.makeText(context, ReceiverB.class.getSimpleName() + " was called", Toast.LENGTH_SHORT).show();
    }

    private void usage2(){
        if (!isOrderedBroadcast()) return;

        int code = getResultCode();
        String data = getResultData();
        Bundle bundle = getResultExtras(true);
        String state = bundle.getString("state");

        String log = "code: " + code + ", result_data: " + data + ", state: " + state;
        Log.i(TAG, log);

        setResultCode(6);
        setResultData("curtain");
        bundle.putString("curtain_state", "open");
        setResultExtras(bundle);
    }
}