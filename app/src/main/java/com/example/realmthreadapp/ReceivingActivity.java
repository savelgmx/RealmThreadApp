package com.example.realmthreadapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.realmthreadapp.model.Person;

import io.realm.Realm;

public class ReceivingActivity extends AppCompatActivity {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving);

        realm = Realm.getDefaultInstance();

        if (getIntent() != null) {
            String personId = getIntent().getStringExtra("person_id");
            if (personId != null) {
                Person person = realm.where(Person.class).equalTo("id", personId).findFirst();
                ((TextView) findViewById(R.id.received_content)).setText(String.format("Received person_id and loaded: %s", person.toString()));
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
