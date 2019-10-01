package com.nightowltechnology.asimyaz.nileconnect;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.Map;

/**
 * Created by asimbyazid on 26/02/2016.
 */
public class PartnersActivity extends AppCompatActivity {

    ImageView partners;

    private Firebase mref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parteners);
        Firebase.setAndroidContext(this);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
/*
       partners =  (ImageView) findViewById(R.id.partners);
        mref = new Firebase("https://nile-connect.firebaseio.com/Partners");
        final TouchImageView img = new TouchImageView(this);

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String p = map.get("partners");
                Picasso.with(PartnersActivity.this).load(p).resize(600,1020).into(new Target() {
                    @Override
                    public void onBitmapLoaded (final Bitmap bitmap,
                                                final Picasso.LoadedFrom loadedFrom) {
                        img.setImageBitmap (bitmap);
                        img.setMaxZoom(4f);
                        setContentView(img);
                    }

                    @Override
                    public void onBitmapFailed (final Drawable drawable) {
                        Log.d("Failure", "Failed");
                    }

                    @Override
                    public void onPrepareLoad (final Drawable drawable) {
                        img.setImageDrawable (drawable);
                    }
                });
                img.setMaxZoom(4f);
                setContentView(img);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/
    }
}
