package com.nightowltechnology.asimyaz.nileconnect;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by asimbyazid on 09/02/2016.
 */
public class CoursesActivity extends AppCompatActivity {
    private TextView txt;
    private String[] courses={"Accounting","Biological Science","Business Administration","Chemistry",
            "Computer Science","Computer Engineering","Civil Engineering","Chemical Engineering ",
            "Economics","Electrical & Electronics Engineering","English Studies","Islamic Law","Law",
            "Petroluem & Gas Engineering","Political Science & International Relations","Physics"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses_listactivity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //txt = (TextView) findViewById(R.id.courses);

        ListAdapter underGrduateCoursesAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,courses);
        ListView list1 = (ListView) findViewById(R.id.coursesid);
        list1.setAdapter(underGrduateCoursesAdapter);


        /*ListAdapter postGrduateCoursesAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,courses);
        ListView list2 = (ListView) findViewById(R.id.coursesid);
        list2.setAdapter(postGrduateCoursesAdapter);*/


        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){

                    case 0:
                        break;

                    case 1:
                        break;

                    case 2:
                        break;

                    case 3:
                        break;

                    case 4:
                        break;

                    case 5:
                        break;

                    case 6:
                        break;

                    case 7:
                        break;

                    case 8:
                        break;

                    case 9:
                        break;

                    case 10:
                        break;

                    case 11:
                        break;

                    case 12:
                        break;

                    case 13:
                        break;

                    case 14:
                        break;

                    case 15:
                        break;
                }
            }
        });

    }
}
