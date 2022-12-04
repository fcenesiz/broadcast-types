package com.example.broadcast_types;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.broadcast_types.databinding.ActivityMainBinding;

/**
 * receiver action names must be same,
 * need to use sendOrderedBroadcast() instead of sendBroadcast()
 */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.buttonRun.setOnClickListener(view ->{
            sendOrderedBroadcast(new Intent(this, ReceiverB.class), null);
            sendOrderedBroadcast(new Intent(this, ReceiverC.class), null);
            sendOrderedBroadcast(new Intent(this, ReceiverA.class), null);
        });
    }
}