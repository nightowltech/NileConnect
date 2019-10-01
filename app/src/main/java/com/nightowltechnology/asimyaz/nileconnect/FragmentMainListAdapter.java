package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Baffa2 on 7/5/2016.
 */
public class FragmentMainListAdapter extends ArrayAdapter<String> {
    public Integer[] image_id = {
            R.drawable.about,R.drawable.admission,R.drawable.news,
            R.drawable.ddirectory,R.drawable.clubs,R.drawable.calendar,
            R.drawable.gallery,R.drawable.dining,R.drawable.timetable,
            R.drawable.transcript,R.drawable.moodle,R.drawable.magazine,
            R.drawable.video,R.drawable.cafeteria,R.drawable.staff,
            R.drawable.downloads,R.drawable.location,R.drawable.emergency
    };
    String[] def = {
            "History of Nile University","Admission guidelines for new entries","Latest Nile news feeds",
            "Academic staff information","Student's clubs","Academic session calendar",
            "Nile university events photo Albums","Dining menu information","Timetable of your department",
            "Student Information System","Student content management system","Read Nile magazines","Watch Nile videos",
            "Be always on budget,know item price","Staff information system","Download texboox and softwares",
            "Find Nile location","Emergency calls and important contacts",
    };

    FragmentMainListAdapter(Context context, String[] menus){super(context,R.layout.custom_row,menus);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myListInflater = LayoutInflater.from(getContext());
        View customView = myListInflater.inflate(R.layout.custom_row, parent, false);

        //String singleDayItems = getItem(position);
        //TextView Text1 = (TextView) customView.findViewById(R.id.custom_textview);
        TextView Text2 = (TextView) customView.findViewById(R.id.custom_textview);
        ImageView Image = (ImageView) customView.findViewById(R.id.custom_img);

        //Text1.setText(singleDayItems);
        Text2.setText(def[position]);
        Image.setImageResource(image_id[position]);
        return customView;


    }
}

