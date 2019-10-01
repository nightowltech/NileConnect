package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class DownloadInfoAcitivity extends AppCompatActivity {

    private Firebase mref;
    private ImageView day_color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_info_acitivity);

        Firebase.setAndroidContext(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        final String mylink = getIntent().getStringExtra("link");

        mref = new Firebase("https://nile-connect.firebaseio.com/DownloadLinks/");
        //Toast toast = Toast.makeText(getApplicationContext(),myurl, Toast.LENGTH_SHORT);
        //toast.show();

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String t = map.get(mylink);


                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(t)));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        this.finish();
        // day_color = (ImageView) findViewById(R.id.t_color);

    }

}