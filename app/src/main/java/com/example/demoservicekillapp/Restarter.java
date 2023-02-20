package com.example.demoservicekillapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

public class Restarter extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Restarter13", "Broadcast Listened Service tried to stop with " + intent.getAction());
        Toast.makeText(context, "Service restarted", Toast.LENGTH_SHORT).show();
//        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){
            Log.d("Restarter16", "Broadcast Listened Service tried to stop" + "Build version Skd" + Build.VERSION.SDK_INT + "Build version Code" + Build.VERSION_CODES.O);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(new Intent(context, YourService.class));
            } else {
                context.startService(new Intent(context, YourService.class));
            }
//        }

    }
}
