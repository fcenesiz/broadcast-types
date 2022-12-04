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
        if (!isOrderedBroadcast()) return;

        int code = getResultCode();
        String data = getResultData();
        Bundle bundle = getResultExtras(true);
        String window_state = bundle.getString("window_state");

        String log = "code: " + code + ", result_data: " + data + ", window_state: " + window_state;
        Log.i(TAG, log);

        setResultCode(8);
        setResultData("breath");
        bundle.putString("breath_state", "take_a_deep_breath");
        setResultExtras(bundle);

        abortBroadcast(); // cuts the broadcast (receiverD will not work)

    }
}
