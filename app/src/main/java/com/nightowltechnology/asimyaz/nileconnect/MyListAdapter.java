package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by asimbyazid on 09/02/2016.
 */
class MyListAdapter extends ArrayAdapter<String> {
    MyListAdapter(Context context, String[] days){
        super(context,R.layout.custom_row,days);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myListInflater = LayoutInflater.from(getContext());
        View customView = myListInflater.inflate(R.layout.custom_row, parent, false);


        String singleDayItems = getItem(position);
        TextView daysText = (TextView) customView.findViewById(R.id.custom_textview);
        ImageView daysImage = (ImageView) customView.findViewById(R.id.custom_img);

        daysText.setText(singleDayItems);
        daysImage.setImageResource(R.drawable.contactus);
        return customView;


    }
}
