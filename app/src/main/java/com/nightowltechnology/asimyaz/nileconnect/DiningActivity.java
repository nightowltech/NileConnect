package com.nightowltechnology.asimyaz.nileconnect;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by asimbyazid on 09/02/2016.
 */
public class DiningActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);
        //ListView v;
        //v = (ListView)findViewById(R.id.listId)

        String[] dining = {"Monday Menu","Tuesday Menu","Wednesday Menu","Thursday Menu","Friday Menu","Saturday Menu","Sunday Menu"};

        android.widget.ListAdapter diningAdapter = new DiningAdapter(this,dining);
        ListView myDining = (ListView) findViewById(R.id.dining_ID);
        myDining.setAdapter(diningAdapter);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        myDining.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch(position){
                    case 0:
                        intent = new Intent(DiningActivity.this,DiningInfoActivity.class);
                         intent.putExtra("day", "monday");
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(DiningActivity.this,DiningInfoActivity.class);
                        intent.putExtra("day", "tuesday");
                        startActivity(intent);

                        break;
                    case 2:
                        intent = new Intent(DiningActivity.this,DiningInfoActivity.class);
                        intent.putExtra("day", "wednesday");
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(DiningActivity.this,DiningInfoActivity.class);
                        intent.putExtra("day", "thursday");
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(DiningActivity.this,DiningInfoActivity.class);
                        intent.putExtra("day", "friday");
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(DiningActivity.this,DiningInfoActivity.class);
                        intent.putExtra("day", "saturday");
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(DiningActivity.this,DiningInfoActivity.class);
                        intent.putExtra("day", "sunday");
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
