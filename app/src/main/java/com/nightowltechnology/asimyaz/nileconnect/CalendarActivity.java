package com.nightowltechnology.asimyaz.nileconnect;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CalendarActivity extends AppCompatActivity {

    RecyclerView CalendarList_Recycler;
    private DatabaseReference mDatabase;

    SwipeRefreshLayout swipeView;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Calendar");
        mDatabase.keepSynced(true);
        String s =""+  mDatabase;
        Log.d("mDatabase is: ", "onCreate: "+s);


        CalendarList_Recycler = (RecyclerView) findViewById(R.id.calendar_ID);
        CalendarList_Recycler.hasFixedSize();
        CalendarList_Recycler.setLayoutManager( new LinearLayoutManager(this));


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<CalendarList,CalendarListViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter <CalendarList,CalendarListViewHolder>(
                CalendarList.class,
                R.layout.custom_row_calendar,
                CalendarListViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(CalendarListViewHolder viewHolder, CalendarList model, int position) {
                viewHolder.setDescription(model.getDescription());
                viewHolder.setDate(model.getDate());


            }
        };
        CalendarList_Recycler.setAdapter(firebaseRecyclerAdapter);
    }

    public static class CalendarListViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public CalendarListViewHolder(View itemView) {
            super(itemView);


            mView = itemView;
        }

        public void setDescription(String d)
        {
            TextView desc = (TextView) mView.findViewById(R.id.custom_desc);
            desc.setText(d);
        }
        public void setDate(String d)
        {
            TextView date = (TextView) mView.findViewById(R.id.custom_date);
            date.setText(d);
        }


    }



    }
