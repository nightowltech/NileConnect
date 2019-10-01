package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;


public class AdmissionActivity extends AppCompatActivity {
    private Firebase mref;
    private Button apply;

    TextView transfer,guideline, requirement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        Firebase.setAndroidContext(this);
        mref = new Firebase("https://nile-connect.firebaseio.com/Admission");

        transfer = (TextView) findViewById(R.id.transfer_doc);
        requirement= (TextView) findViewById(R.id.required_doc);
        guideline = (TextView) findViewById(R.id.guideline);

        apply = (Button) findViewById(R.id.apply);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(AdmissionActivity.this, WebViewActivity.class);
                intent1.putExtra("url","http://www.sis.nileuniversity.edu.ng/my/app/");
                startActivity(intent1);
            }
        });
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String t = map.get("transfer");
                String r = map.get("requirement");
                String g = map.get("guidelines");


                transfer.setText(t);
                requirement.setText(r);
                guideline.setText(g);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admission_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_apply) {
            Intent intent1 = new Intent(AdmissionActivity.this, WebViewActivity.class);
            intent1.putExtra("url","http://www.sis.nileuniversity.edu.ng/my/app/");
            startActivity(intent1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
