package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by asimbyazid on 27/02/2016.
 */
class DiningAdapter extends ArrayAdapter<String> {
    public Integer[] my_menus = {
            R.drawable.mb,R.drawable.tlh,R.drawable.wlsa,
            R.drawable.thlsb,R.drawable.fd,R.drawable.sb,
            R.drawable.sunlh
    };
    DiningAdapter(Context context, String[] menus){super(context,R.layout.custom_row,menus);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myListInflater = LayoutInflater.from(getContext());
        View customView = myListInflater.inflate(R.layout.custom_row, parent, false);

        //String singleDayItems = getItem(position);
        String[] dining = {"Monday Menu","Tuesday Menu","Wednesday Menu","Thursday Menu","Friday Menu","Saturday Menu","Sunday Menu"};
        //TextView Text1 = (TextView) customView.findViewById(R.id.custom_textview);
        TextView Text2 = (TextView) customView.findViewById(R.id.custom_textview);
        ImageView Image = (ImageView) customView.findViewById(R.id.custom_img);

        //Text1.setText(singleDayItems);
        Text2.setText(dining[position]);
        Image.setImageResource(my_menus[position]);
        return customView;


    }
}

