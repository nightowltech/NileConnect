package com.nightowltechnology.asimyaz.nileconnect;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMainList extends Fragment {
    Intent item1;


    public FragmentMainList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_list, container, false);
        String[] def = {
                "History of Nile University","Admission guidelines for new entries","Latest Nile news feeds",
                "Academic staff information","Student's clubs","Academic session calendar",
                "Nile university events photo Albums","Dining menu information","Timetable of your department",
                "Student Information System","Student content management system","Read Nile magazines","Watch Nile videos",
                "Be always on budget,know item price","Staff information system","Download texboox and softwares",
                "Find Nile location","Emergency calls and important contacts",
        };
        android.widget.ListAdapter LandAdapter = new FragmentMainListAdapter(getActivity(),def);
        ListView myLandscape = (ListView) view.findViewById(R.id.main_list);
        myLandscape.setAdapter(LandAdapter);

        myLandscape.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch (position) {
                    case 0:
                        //Intent intent1 = new Intent(MainActivity.this,My_web.class);
                        //.putExtra("url","http://www.ntnumssn.blogspot.com.ng/p/about-us.html?m=1");
                        //startActivity(intent1);
                        Intent intent1 = new Intent(getActivity(), AboutActivity.class);
                        startActivity(intent1);
                        break;
                    case 1:
                        intent1 = new Intent(getActivity(), AdmissionActivity.class);
                        startActivity(intent1);

                        break;
                    case 2:
                        item1= new Intent(getActivity(),NewsActivity.class);
                        //item1.putExtra("url","http://www.owsf.org.ng/nileconnect_twitter.html");
                        startActivity(item1);
                        break;

                    case 3:
                        item1 = new Intent(getActivity(), DirectoryActivity.class);
                        startActivity(item1);
                        break;
                    case 4:
                        item1 = new Intent(getActivity(), ClubsActivity.class);
                        startActivity(item1);
                        break;
                    case 5:
                        item1 = new Intent(getActivity(), CalendarActivity.class);
                        startActivity(item1);
                        break;
                    case 6:
                        item1 = new Intent(getActivity(), PhotosActivity.class);
                        startActivity(item1);
                        break;
                    case 7:
                        intent1 = new Intent(getActivity(), DiningActivity.class);
                        startActivity(intent1);
                        break;
                    case 8:
                        intent1 = new Intent(getActivity(), TimetableActivity.class);
                        startActivity(intent1);
                        break;
                    case 9:
                        item1 = new Intent(getActivity(), StudentInfoSys.class);
                        startActivity(item1);
                        break;
                    case 10:
                        item1 = new Intent(getActivity(),MoodleActivity.class);
                        startActivity(item1);
                        break;
                    case 11:
                        intent1 = new Intent(getActivity(), MagazinesActivity.class);
                        //intent1.putExtra("url", "http://ntnumssn.blogspot.com.ng/p/blog-page.html?m=1");
                        startActivity(intent1);
                        break;
                    case 12:
                        item1 = new Intent(getActivity(), VideosActivity.class);
                        startActivity(item1);
                        break;
                    case 13:
                        intent1 = new Intent(getActivity(), CanteenActivity.class);
                        // intent1.putExtra("url","http://ntnumssn.blogspot.com.ng/p/contact-us.html?m=1");
                        startActivity(intent1);
                        break;
                    case 14:
                        intent1 = new Intent(getActivity(), WebViewActivity.class);
                        intent1.putExtra("url","http://www.sis.ntnu.edu.ng/pms");
                        startActivity(intent1);
                        break;

                    case 15:
                        intent1 = new Intent(getActivity(),DownloadsActivity.class);
                        // intent1.putExtra("url","http://ntnumssn.blogspot.com.ng/p/contact-us.html?m=1");
                        startActivity(intent1);
                        break;

                    case 16:
                        intent1 = new Intent(getActivity(), MapsActivity.class);
                        // intent1.putExtra("url","http://ntnumssn.blogspot.com.ng/p/contact-us.html?m=1");
                        startActivity(intent1);
                        break;

                    case 17:
                        intent1 = new Intent(getActivity(), EmergencyActivity.class);
                        // intent1.putExtra("url","http://ntnumssn.blogspot.com.ng/p/contact-us.html?m=1");
                        startActivity(intent1);
                        break;

                }
            }
        });
        return view;
    }

}
