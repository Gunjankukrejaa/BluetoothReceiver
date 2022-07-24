package com.example.bluetoothreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    BluetoothModeChangeReceiver bluetoothModeChangeReceiver=new BluetoothModeChangeReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        IntentFilter filter=new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(bluetoothModeChangeReceiver,filter);
    }

    @Override
    protected void onStop(){
        super.onStop();
        unregisterReceiver(bluetoothModeChangeReceiver);
    }
}