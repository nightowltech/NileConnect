package com.nightowltechnology.asimyaz.nileconnect;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Map;

public class AboutActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout=null;

    private Firebase mref;
    TextView para1,para2,para3,para4,para5,para6,para7,para8;
    String paragraph1,paragraph2,paragraph3,paragraph4,paragraph5,paragraph6,paragraph7,paragraph8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Firebase.setAndroidContext(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mref = new Firebase("https://nile-connect.firebaseio.com/About");

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar_about);
        collapsingToolbarLayout.setTitle("About");

       // dynamicToolbarColor();
        //toolbarTextAppearnce();

        para1 = (TextView) findViewById(R.id.p1);
        para2 = (TextView) findViewById(R.id.p2);
        para3 = (TextView) findViewById(R.id.p3);
        para4 = (TextView) findViewById(R.id.p4);
        para5 = (TextView) findViewById(R.id.p5);
        para6 = (TextView) findViewById(R.id.p6);
        para7 = (TextView) findViewById(R.id.p7);
        para8 = (TextView) findViewById(R.id.p8);

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, String> map = dataSnapshot.getValue(Map.class);

                paragraph1 = map.get("paragraph1");
                paragraph2 = map.get("paragraph2");
                paragraph3 = map.get("paragraph3");
                paragraph4 = map.get("paragraph4");
                paragraph5 = map.get("paragraph5");
                paragraph6 = map.get("paragraph6");
                paragraph7 = map.get("paragraph7");
                paragraph8 = map.get("paragraph8");

                para1.setText(paragraph1);
                para2.setText(paragraph2);
                para3.setText(paragraph3);
                para4.setText(paragraph4);
                para5.setText(paragraph5);
                para6.setText(paragraph6);
                para7.setText(paragraph7);
                para8.setText(paragraph8);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }

}


