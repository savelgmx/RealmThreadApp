package com.example.realmthreadapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

public class WakefulReceivingBroadcastReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Do not do work in onReceive as it can cause an ANR. Perform work in a
        // service as to avoid the ANR.
        Intent serviceIntent = new Intent(context, WakefulReceivingService.class);
        serviceIntent.putExtra("person_id", intent.getStringExtra("person_id"));
        startWakefulService(context, serviceIntent);
    }
}