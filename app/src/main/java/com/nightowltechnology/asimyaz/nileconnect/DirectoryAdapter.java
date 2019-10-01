package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by asimbyazid on 09/02/2016.
 */




class DirectoryAdapter extends ArrayAdapter<String> {

    public Integer[] image_id = {
            R.drawable.vc_crop, R.drawable.dvc_crop, R.drawable.dvcadmin_crop, R.drawable.default_crop, R.drawable.diracademic_crop,
            R.drawable.deanpostgrad_crop, R.drawable.deanfnas_crop, R.drawable.deaneng_crop, R.drawable.deanart_crop,
            R.drawable.default_crop, R.drawable.hodbusadmin_crop, R.drawable.hodchem_crop, R.drawable.hodecons_crop,
            R.drawable.hodeng_crop, R.drawable.hodenglish_crop, R.drawable.hodpol_crop, R.drawable.default_crop, R.drawable.default_crop,
            R.drawable.pr_crop,
    };
    private String info[] =
            {"Room: 311", "Room: 307", "Room: 305", "Room: 312", "Room: 315",
                    "Room: 304", "Room: 103", "Room: 104", "Room: 231", "Room: 105",
                    "Room: 222", "Room: 106", "Room: 230", "Room: 111", "Room: 229", "Room: 228", "Room: 134", "Room: 101",
                    "Room: 106"

            };
    private String title[] = {"Vice Chancellor", "Deputy Vice Chancellor", "Deputy Vice Chancellor admin", "Registrar", "Director Academi Planning",
            "Dean Post Graduates", "Dean FNAS", "Dean Faculty of Engineering", "Dean Art,Mgt & Social Science", "HOD Computer Science",
            "HOD Business Admin", "HOD Chemistry", "HOD Economics", "HOD Electrical & Electronics Engineering", "HOD English",
            "HOD Political Science", "HOD Biological Science", "HOD Civil Engineering",
            "Public Relations"
    };

    DirectoryAdapter(Context context, String[] staff) {
        super(context, R.layout.custom_row2, staff);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myListInflater = LayoutInflater.from(getContext());
        View customView = myListInflater.inflate(R.layout.custom_row2, parent, false);

        String names = getItem(position);
        TextView Text1 = (TextView) customView.findViewById(R.id.custom_name);
        TextView Text2 = (TextView) customView.findViewById(R.id.custom_textview2);
        //TextView Text3 = (TextView) customView.findViewById(R.id.custom_textview3);

        ImageView Image = (ImageView) customView.findViewById(R.id.custom_img2);

        Text1.setText(names);
        Text2.setText(info[position]);
        //Text3.setText(title[position]);
        Image.setImageResource(image_id[position]);
        return customView;


    }
}