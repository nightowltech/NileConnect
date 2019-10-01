package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyImageViewerActivity extends AppCompatActivity {

    public Integer[] image_id = {
            R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
            R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
            R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
            R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
            R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
            R.drawable.timetable_csc,
    };

    private int counter=-1;
    private int checker=-1;
    private SharedPreferences prefs;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_image_viewer);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        final TouchImageView imgv = new TouchImageView(this);

        checker = readPrefValues();
        if(checker==-1) {
            imgv.setImageResource(R.drawable.nileconnectlogo);
            imgv.setMaxZoom(4f);
            setContentView(imgv);

        }
        else
        {
            prefs = getSharedPreferences("Mypref", Context.MODE_PRIVATE);
            imgv.setImageResource(image_id[checker]);
            imgv.setMaxZoom(4f);
            setContentView(imgv);
        }

    }
    public int readPrefValues() {
        prefs = this.getSharedPreferences("Mypref", Context.MODE_PRIVATE);
        int value = prefs.getInt("pos",counter);
        //counter = value;

        return value;

    }

}
