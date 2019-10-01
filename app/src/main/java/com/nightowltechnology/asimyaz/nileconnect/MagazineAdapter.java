package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Asim on 8/11/2015.
 */
public class MagazineAdapter extends ArrayAdapter<String> {
    public Integer[] image_id = {
			R.drawable.magconvoc,R.drawable.mag,R.drawable.maga,
            R.drawable.magb,R.drawable.magc,R.drawable.magd,
            R.drawable.mage,R.drawable.magf,R.drawable.magg,
    };
    MagazineAdapter(Context context, String[] m){super(context,R.layout.custom_row_magazines,m);
    }

    @Override
    public int getCount() {
        return image_id.length;
    }

    @Override
    public String getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getPosition(String item) {
        return super.getPosition(item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myListInflater = LayoutInflater.from(getContext());
        View customView = myListInflater.inflate(R.layout.custom_row_magazines, parent, false);

        //String singleDayItems = getItem(position);
        String[] magazine ={
                "Nile Convocation 2015","Nile News ","Nile News Issue 1",
                "Nile News Issue 2","Nile News Issue 3","Nile News Issue 4",
                "Nile News Issue 5","Nile News Issue 6","Nile News Issue 7"};
        //TextView Text1 = (TextView) customView.findViewById(R.id.custom_textview);
        TextView Text2 = (TextView) customView.findViewById(R.id.custom_textview_mag);
        ImageView Image = (ImageView) customView.findViewById(R.id.custom_img_mag);

        //Text1.setText(singleDayItems);
        try{
            Text2.setText(magazine[position]);
            Image.setImageResource(image_id[position]);}
        catch (Throwable t)
        {
            //Haba samsung
        }
        return customView;


    }
}

