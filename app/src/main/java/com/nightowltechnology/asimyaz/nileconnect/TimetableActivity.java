package com.nightowltechnology.asimyaz.nileconnect;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import javax.xml.datatype.Duration;

/**
 * Created by asimbyazid on 09/02/2016.
 */
public class TimetableActivity extends AppCompatActivity {


    private Firebase mref;
    private ListView mylist;
    private ArrayList<String> mDepartments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses_listactivity);
        Firebase.setAndroidContext(this);


        mref = new Firebase("https://nile-connect.firebaseio.com/Departments");
        mylist = (ListView) findViewById(R.id.coursesid);




        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mDepartments);
        mylist.setAdapter(arrayAdapter);


        mref.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                mDepartments.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mDepartments.remove(value);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast toast = Toast.makeText(getApplicationContext(),mDepartments.get(position).toString().replaceAll("\\s+",""), Toast.LENGTH_SHORT);
                //toast.show();


                Intent intent = new Intent(TimetableActivity.this,TimetableInfoActivity.class);


                intent.putExtra("department",mDepartments.get(position).toString().replaceAll("\\s+",""));

                startActivity(intent);



            }
        });

    }

    /*
    private TextView txt;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses_listactivity);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //txt = (TextView) findViewById(R.id.courses);
        final TouchImageView img = new TouchImageView(this);

        final String[] courses={
                "Accounting","Biological Science","Bussiness Admisnistatrion","Chemistry",
                "Computer Science","Computer Engineering","Civil Engineering","Chemical Engineering ",
                "Econonmics","Electrical & Electronics Engineering","English Studies","Islamic Law","Law",
                "Petroluem & Gas Engineering","Political Science & International Relations","Physics"};

        final Integer[] image_id = {
                R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
                R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
                R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
                R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
                R.drawable.timetable_csc,R.drawable.timetable_csc,R.drawable.timetable_csc,
                R.drawable.timetable_csc,
        };

        ListAdapter myCourseAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,courses);
        ListView list = (ListView) findViewById(R.id.coursesid);
        list.setAdapter(myCourseAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                        img.setImageResource(image_id[position]);
                         img.setMaxZoom(4f);
                        setContentView(img);

            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                prefs = getSharedPreferences("Mypref", MODE_PRIVATE);
                final SharedPreferences.Editor editor = prefs.edit();
                final Intent i = new Intent(TimetableActivity.this,MainActivity.class);

                AlertDialog.Builder builder = new AlertDialog.Builder(TimetableActivity.this);

                builder.setMessage("are you sure you want to save "+courses[position]+" timetable as my favourite ?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        editor.putInt("pos",position);
                        editor.apply();
                        Toast.makeText(TimetableActivity.this, courses[position]+" is now my favourite!!", Toast.LENGTH_LONG).show();
                        startActivity(i);

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog= builder.create();
                alertDialog.show();

                        //Toast.makeText(getApplicationContext(), ""+position, Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
    */
}
