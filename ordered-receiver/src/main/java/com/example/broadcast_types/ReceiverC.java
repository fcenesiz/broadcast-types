package com.example.broadcast_types;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ReceiverC  extends BroadcastReceiver {
    public static final String TAG = ReceiverC.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        usage2();
        Toast.makeText(context, ReceiverC.class.getSimpleName() + " was called", Toast.LENGTH_SHORT).show();
    }

    private void usage2(){
        if (!isOrderedBroadcast()) return;

        int code = getResultCode();
        String data = getResultData();
        Bundle bundle = getResultExtras(true);
        String curtain_state = bundle.getString("curtain_state");

        String log = "code: " + code + ", result_data: " + data + ", curtain_state: " + curtain_state;
        Log.i(TAG, log);

        setResultCode(7);
        setResultData("window");
        bundle.putString("window_state", "open");
        setResultExtras(bundle);
    }

}