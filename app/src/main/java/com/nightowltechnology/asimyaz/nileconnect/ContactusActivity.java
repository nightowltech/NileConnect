package com.nightowltechnology.asimyaz.nileconnect;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class ContactusActivity extends AppCompatActivity {

    private TextView address,email,time,phone;

    private String my_address,my_email,my_time,my_phone;

    private Firebase mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Firebase.setAndroidContext(this);

        address = (TextView) findViewById(R.id.c_address);
        email = (TextView) findViewById(R.id.c_email);
        time = (TextView) findViewById(R.id.c_time);
        phone = (TextView) findViewById(R.id.c_phone);

        mref = new Firebase("https://nile-connect.firebaseio.com/Contact");


        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, String> map = dataSnapshot.getValue(Map.class);
                my_address = map.get("address");
                my_email = map.get("email");
                my_time = map.get("time");
                my_phone = map.get("phone");


                address.setText(my_address);
                email.setText(my_email);
                time.setText(my_time);
                phone.setText(my_phone);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

}
