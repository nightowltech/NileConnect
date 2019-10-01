package com.nightowltechnology.asimyaz.nileconnect;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.annotation.ColorRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TimetableInfoActivity extends AppCompatActivity {


    RecyclerView TimetableList_Recycler;
    private DatabaseReference mDatabase;
    private ImageView day_color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_info);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        final String myurl = getIntent().getStringExtra("department");

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Timetable/"+myurl);
        mDatabase.keepSynced(true);
        //Toast toast = Toast.makeText(getApplicationContext(),myurl, Toast.LENGTH_SHORT);
        //toast.show();

        String s =""+  mDatabase;
        Log.d("mDatabase is: ", "onCreate: "+s);

        TimetableList_Recycler = (RecyclerView) findViewById(R.id.time_ID);
        TimetableList_Recycler.hasFixedSize();
        TimetableList_Recycler.setLayoutManager( new LinearLayoutManager(this));


       // day_color = (ImageView) findViewById(R.id.t_color);

    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<TimetableList,TimetableListViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter <TimetableList,TimetableListViewHolder>(
                TimetableList.class,
                R.layout.custom_row_timtable,
                TimetableListViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(TimetableListViewHolder viewHolder, TimetableList model, int position) {
                viewHolder.setDay(model.getDay());
                //String s = model.getDay().toString();
                viewHolder.setName(model.getName());
                viewHolder.setTime(model.getTime());
                viewHolder.setVenue(model.getVenue());

            }
        };


        TimetableList_Recycler.setAdapter(firebaseRecyclerAdapter);
    }
    public static class TimetableListViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public TimetableListViewHolder(View itemView) {
            super(itemView);


            mView = itemView;
        }

        public void setName(String n)
        {
            TextView name = (TextView) mView.findViewById(R.id.t_name);
            name.setText(n);
        }
        public void setDay(String d)
        {
            TextView day = (TextView) mView.findViewById(R.id.t_day);
            day.setText(d);
        }
        public void setTime(String t)
        {
            TextView time = (TextView) mView.findViewById(R.id.t_time);
            time.setText(t);
        }

        public void setVenue(String v)
        {
            TextView venue = (TextView) mView.findViewById(R.id.t_venue);
            venue.setText(v);
        }




    }
}
