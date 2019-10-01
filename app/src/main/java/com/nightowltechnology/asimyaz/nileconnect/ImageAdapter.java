package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Asim on 8/11/2015.
 */
public class ImageAdapter extends BaseAdapter {
    protected static Context ctx;
    public Integer[] image_id = {
            R.drawable.about,R.drawable.admission,R.drawable.news,
            R.drawable.ddirectory,R.drawable.clubs,R.drawable.calendar,
            R.drawable.gallery,R.drawable.dining,R.drawable.src,
            R.drawable.transcript,R.drawable.sport_icon,
            R.drawable.video,R.drawable.cafeteria,R.drawable.staff,
            R.drawable.downloads,R.drawable.location,R.drawable.emergency,R.drawable.facebook,
            R.drawable.twitter
    };
    public ImageAdapter(Context CTX){
        this.ctx = CTX;

    }
    @Override
    public int getCount() {
        return image_id.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView img;
        if(convertView==null)
        {
            img = new ImageView(ctx);
            img.setLayoutParams(new GridView.LayoutParams(150,150));
            img.setPadding(2,2,2,2);
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);

        }
        else
        {
            img = (ImageView) convertView;
        }
        img.setImageResource(image_id[position]);

        return img;
    }
}

