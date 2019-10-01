package com.nightowltechnology.asimyaz.nileconnect;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Baffa2 on 7/3/2017.
 */

public class FireNile extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
