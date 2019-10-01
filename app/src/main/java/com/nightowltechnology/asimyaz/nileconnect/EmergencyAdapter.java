package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by asimbyazid on 01/03/2016.
 */
public class EmergencyAdapter extends ArrayAdapter<String> {
    EmergencyAdapter(Context context, String[] staff){
        super(context,R.layout.custom_row3,staff);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myListInflater = LayoutInflater.from(getContext());
        View customView = myListInflater.inflate(R.layout.custom_row3, parent, false);

        String singleDayItems = getItem(position);
        final String info[]={"099","+2348078228208","+2348117438542"," +2348056339444","+2348116907930","+234","+2347012441027"};

        TextView Text1 = (TextView) customView.findViewById(R.id.custom_textviewemg1);
        TextView Text2 = (TextView) customView.findViewById(R.id.custom_textviewemg2);

        Text1.setText(singleDayItems);
        Text2.setText(info[position]);
        return customView;


    }
}
