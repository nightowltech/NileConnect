package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by asimbyazid on 29/03/2016.
 */
public class PhotosAdapter extends ArrayAdapter<String> {
    public Integer[] image_id = {
            R.drawable.festival,R.drawable.parka,R.drawable.lab,
            R.drawable.nesa,R.drawable.nticfa,R.drawable.nticfb,
            R.drawable.places,R.drawable.moments,R.drawable.omrah,
            R.drawable.bus,R.drawable.visit,R.drawable.nilesports,
            R.drawable.campus,R.drawable.parka,R.drawable.picnica
    };
    PhotosAdapter(Context context, String[] menus){super(context,R.layout.custom_row_photos,menus);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myListInflater = LayoutInflater.from(getContext());
        View customView = myListInflater.inflate(R.layout.custom_row_photos, parent, false);


        String[] gallery =
                {
                        "International Friendship Festival","Park & Zoo Picnic","Nile Laboratories",
                        "NESA: Nigerian Economic Students Association","Nile students Participate in NTICF Charity event 1","NTIC Foundation Stationaries Program with Nile Students",
                        "Nile Places","General Nile Moments","MSSN: Omrah trip",
                        "Bussiness club visit to Ufuk Dialog","Home Visit to Parent","Sports Activities",
                        "Life OnCampus","Park & Zoo Outing 100 level","Park & Zoo Outing 400 level"};

        TextView Text2 = (TextView) customView.findViewById(R.id.custom_textview);
        ImageView Image = (ImageView) customView.findViewById(R.id.custom_img);

        Text2.setText(gallery[position]);
        Image.setImageResource(image_id[position]);
        return customView;


    }
}

