package com.example.broadcast_types;

import android.content.Intent;
import android.content.IntentFilter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ShareCompat;
import com.example.broadcast_types.databinding.ActivityMainBinding;

/**
 * receivers need to registered as dynamic,
 * receiver action names must be same,
 * need to use sendOrderedBroadcast() instead of sendBroadcast()
 */
public class MainActivity extends AppCompatActivity {

    private final String action = "my.same.named.action.name";

    private ReceiverA receiverA = new ReceiverA();
    private ReceiverB receiverB = new ReceiverB();
    private ReceiverC receiverC = new ReceiverC();
    private ReceiverD receiverD = new ReceiverD();

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonRun.setOnClickListener(view ->{
            this.usage2();
        });
    }

    private void usage1(){ // send empty broadcast
        Intent intent = new Intent(action);
        sendOrderedBroadcast(intent, null);
    }

    private void usage2(){ // send filled broadcast
        Bundle bundle = new Bundle();
        bundle.putString("state", "sunshine");

        Intent intent = new Intent(action);
        sendOrderedBroadcast(
                intent,
                null,
                receiverD, // result broadcast
                null,
                RESULT_OK,
                "weather",
                bundle
        );
    }

    private void registerReceivers(){
        registerReceiver(receiverA, new CustomIntentFilter.Builder()
                .addAction(action)
                .setPriority(10)
                .build());
        registerReceiver(receiverB, new CustomIntentFilter.Builder()
                .addAction(action)
                .setPriority(30)
                .build());
        registerReceiver(receiverC, new CustomIntentFilter.Builder()
                .addAction(action)
                .setPriority(20)
                .build());
        registerReceiver(receiverD, new CustomIntentFilter.Builder()
                .addAction(action)
                .setPriority(5)
                .build());
    }
    private void unRegisterReceivers(){
        unregisterReceiver(receiverA);
        unregisterReceiver(receiverB);
        unregisterReceiver(receiverC);
        unregisterReceiver(receiverD);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceivers();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unRegisterReceivers();
    }
}