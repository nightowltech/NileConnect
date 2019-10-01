package com.nightowltechnology.asimyaz.nileconnect;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;


/**
 * A simple {@link Fragment} subclass.
 */
public  class  FragmentMyTimetable extends Fragment {

    public Integer[] image_id = {
            R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
            R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
            R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
            R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
            R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
            R.drawable.timetable_csc,
    };
    private TextView info;
    private ImageView img;
    private TextView txt;
    private int counter=-1;
    private int checker=-1;
    private SharedPreferences prefs;
    private Button btn;


    public FragmentMyTimetable() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_my_timetable, container, false);


        info =(TextView) view.findViewById(R.id.text_fav);
        img = (ImageView) view.findViewById(R.id.favourite);
        btn = (Button) view.findViewById(R.id.apply);
        checker = readPrefValues();
       // checker=counter;
       // Toast.makeText(getActivity(),""+checker,Toast.LENGTH_LONG).show();
        prefs = getActivity().getSharedPreferences("Mypref", Context.MODE_PRIVATE);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),TimetableActivity.class);
                startActivity(i);
            }
        });

        if(checker==-1) {
            img.setImageResource(R.drawable.nileconnectlogo);

        }
        else
        {

            img.setImageResource(image_id[checker]);
            info.setVisibility(View.GONE);
        }
        // Inflate the layout for this fragment
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent i = new Intent(getActivity(),MyImageViewerActivity.class);
               startActivity(i);
            }
        });
        return view;
    }

    public int readPrefValues() {
        prefs = getActivity().getSharedPreferences("Mypref", Context.MODE_PRIVATE);
        int value = prefs.getInt("pos",counter);
        //counter = value;

        return value;

    }

}
