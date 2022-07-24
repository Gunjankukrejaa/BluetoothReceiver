package com.example.bluetoothreceiver;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class BluetoothModeChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        final String action = intent.getAction();

        if(action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)){
            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,BluetoothAdapter.ERROR);
            switch (state){
                case BluetoothAdapter.STATE_OFF:
                    Toast.makeText(context, "Bluetooth is off", Toast.LENGTH_SHORT).show();
                    break;

                case BluetoothAdapter.STATE_TURNING_OFF:
                    Toast.makeText(context, "Bluetooth is turning off", Toast.LENGTH_SHORT).show();
                    break;

                case BluetoothAdapter.STATE_ON:
                    Toast.makeText(context, "Bluetooth is on", Toast.LENGTH_SHORT).show();
                    break;

                case BluetoothAdapter.STATE_TURNING_ON:
                    Toast.makeText(context, "Bluetooth is turning on", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

}


