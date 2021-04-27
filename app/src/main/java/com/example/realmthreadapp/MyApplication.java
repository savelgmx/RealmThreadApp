package com.example.realmthreadapp;


import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

//попытка разобраться с куфдь еркувы
//перенос приложения из https://github.com/realm/realm-java/tree/master/examples/threadExample/src/main/java/io/realm/examples/threads



public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Configure Realm for the application
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.deleteRealm(realmConfiguration); // Clean slate
        Realm.setDefaultConfiguration(realmConfiguration); // Make this Realm the default
    }
}
