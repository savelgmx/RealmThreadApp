package com.example.realmthreadapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.example.realmthreadapp.model.Person;



import io.realm.Realm;

public class ReceivingService extends IntentService {

    public ReceivingService() {
        super("ReceivingService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent.getExtras() != null) {
            String personId = intent.getStringExtra("person_id");
            Realm realm = Realm.getDefaultInstance();
            Person person = realm.where(Person.class).equalTo("id", personId).findFirst();
            final String output = person.toString();
            new Handler(getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Loaded Person from intent service: " + output, Toast.LENGTH_LONG).show();
                }
            });
            realm.close();
        }
    }
}