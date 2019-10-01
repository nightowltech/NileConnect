package com.nightowltechnology.asimyaz.nileconnect;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFaculties extends android.support.v4.app.Fragment {
    private Button btn;


    public FragmentFaculties() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_faculties, container, false);

        btn = (Button) view.findViewById(R.id.apply);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), WebViewActivity.class);
                intent1.putExtra("url","http://ntnu.edu.ng/?online_application");
                startActivity(intent1);
            }
        });
        return view;
    }


}
