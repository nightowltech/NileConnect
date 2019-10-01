package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Map;

import static com.nightowltechnology.asimyaz.nileconnect.ImageAdapter.ctx;

/**
 * Created by asimbyazid on 09/02/2016.
 */
public class DiningInfoActivity extends AppCompatActivity {

    ImageView breakfast_img, lunch_img, lunch_img_h, lunch2_img, dinner_img;
    TextView breakfast_myText, lunch_myText, lunch_myText_h, lunch2_myText, dinner_myText;
    TextView breakfast_header, lunch_header, lunch_header_h, lunch2_header, dinner_header;
    TextView lunch2_location, lunch_location, lunch_location_h, breakfast_location, dinner_location;
    TextView lunch_time, lunch_time_h, lunch2_time, breakfast_time, dinner_time;
    TextView day;


    String bf_header, l_header, l_header_h, l2_header, d_header;
    String bf_menu, l_menu, l_menu_h, l2_menu, d_menu;
    String bf_img, l_img, l_img_h, l2_img, d_img;
    String bf_location, l_location, l_location_h, l2_location, d_location;
    String bf_time, l_time, l_time_h, l2_time, d_time;

    private Firebase mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dining_info);
        Firebase.setAndroidContext(this);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        breakfast_img = (ImageView) findViewById(R.id.monimg);
        breakfast_myText = (TextView) findViewById(R.id.monlist);
        breakfast_header = (TextView) findViewById(R.id.breakfast);
        breakfast_time = (TextView) findViewById(R.id.time1);
        breakfast_location = (TextView) findViewById(R.id.loc1);
        day = (TextView) findViewById(R.id.menu);


        lunch_img = (ImageView) findViewById(R.id.lunchimg1);
        lunch_myText = (TextView) findViewById(R.id.lunchlist1);
        lunch_header = (TextView) findViewById(R.id.lunch1);
        lunch_time = (TextView) findViewById(R.id.time2);
        lunch_location = (TextView) findViewById(R.id.loc2);


        lunch_img_h = (ImageView) findViewById(R.id.lunchimg_hostel);
        lunch_myText_h = (TextView) findViewById(R.id.lunchlist_hostel);
        lunch_header_h = (TextView) findViewById(R.id.lunch_hostel);
        lunch_time_h = (TextView) findViewById(R.id.time2_hostel);
        lunch_location_h = (TextView) findViewById(R.id.loc2_hostel);


        lunch2_img = (ImageView) findViewById(R.id.lunchimg2);
        lunch2_myText = (TextView) findViewById(R.id.lunchlist2);
        lunch2_header = (TextView) findViewById(R.id.lunch2);
        lunch2_time = (TextView) findViewById(R.id.time3);
        lunch2_location = (TextView) findViewById(R.id.loc3);


        dinner_img = (ImageView) findViewById(R.id.dinnerimg);
        dinner_myText = (TextView) findViewById(R.id.dinnerlist);
        dinner_header = (TextView) findViewById(R.id.dinner);
        dinner_time = (TextView) findViewById(R.id.time4);
        dinner_location = (TextView) findViewById(R.id.loc4);


        String dow = getIntent().getStringExtra("day");


        switch (dow) {
            case "monday":

                mref = new Firebase("https://nile-connect.firebaseio.com/Dining/Monday");

                break;
            case "tuesday":

                mref = new Firebase("https://nile-connect.firebaseio.com/Dining/Tuesday");

                break;
            case "wednesday":

                mref = new Firebase("https://nile-connect.firebaseio.com/Dining/Wednesday");

                break;
            case "thursday":

                mref = new Firebase("https://nile-connect.firebaseio.com//Dining/Thursday");

                break;
            case "friday":

                mref = new Firebase("https://nile-connect.firebaseio.com/Dining/Friday");

                break;
            case "saturday":

                mref = new Firebase("https://nile-connect.firebaseio.com/Dining/Saturday");

                break;
            case "sunday":

                mref = new Firebase("https://nile-connect.firebaseio.com/Dining/Sunday");

                break;

        }

        //header1.setText("Breakfast");


        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String which_day = map.get("header");
                day.setText(which_day);

                bf_menu = map.get("bf_menu");
                bf_img = map.get("bf_img");
                bf_location = map.get("bf_location");
                bf_time = map.get("bf_time");

                l_header_h = map.get("lunch_h_header");
                l_menu_h = map.get("lunch_h_menu");
                l_img_h = map.get("lunch_h_img");
                l_location_h = map.get("lunch_h_location");
                l_time_h = map.get("lunch_h_time");


                l_header = map.get("lunch_header");
                l_menu = map.get("lunch_menu");
                l_img = map.get("lunch_img");
                l_location = map.get("lunch_location");
                l_time = map.get("lunch_time");


                l2_header = map.get("lunch2_header");
                l2_menu = map.get("lunch2_menu");
                l2_img = map.get("lunch2_img");
                l2_location = map.get("lunch2_location");
                l2_time = map.get("lunch2_time");


                d_header = map.get("dinner_header");
                d_menu = map.get("dinner_menu");
                d_img = map.get("dinner_img");
                d_location = map.get("dinner_location");
                d_time = map.get("dinner_time");


                Picasso.with(DiningInfoActivity.this).load(bf_img).resize(500,500).into(breakfast_img);
                breakfast_myText.setText(bf_menu);
                breakfast_header.setText(bf_header);
                breakfast_location.setText(bf_location);
                breakfast_time.setText(bf_time);


                Picasso.with(DiningInfoActivity.this).load(l_img).resize(500,500).into(lunch_img_h);
                lunch_myText_h.setText(l_menu);
                lunch_header_h.setText(l_header);
                lunch_time_h.setText(l_time);
                lunch_location_h.setText(l_location);


                Picasso.with(DiningInfoActivity.this).load(l_img).resize(500,500).into(lunch_img);
                lunch_myText.setText(l_menu);
                lunch_header.setText(l_header);
                lunch_time.setText(l_time);
                lunch_location.setText(l_location);


                Picasso.with(DiningInfoActivity.this).load(l2_img).resize(500,500).into(lunch2_img);
                lunch2_myText.setText(l2_menu);
                lunch2_header.setText(l2_header);
                lunch2_time.setText(l2_time);
                lunch2_location.setText(l2_location);


                Picasso.with(DiningInfoActivity.this).load(d_img).resize(500,500).into(dinner_img);
                dinner_myText.setText(d_menu);
                dinner_header.setText(d_header);
                dinner_time.setText(d_time);
                dinner_location.setText(d_location);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}

        /*
        switch (dow)
        {
            case "monday":
                break;

            case "tuesday":

  /*
                header.setText("Tuesday Menu");
                //header1.setText("Breakfast");
                img1.setImageResource(R.drawable.tb);
                myText1.setText("" + "-Tea\n-Milk\n-Milo\n-Bread\n-Jam\n-Blue Band\n-Quaker Oats\n-Doughnut\n-Corn flakes\n-Time: 7:30am-8:30am\n-Location: Hostel(Boys/Girls)");

                break;

                //header2.setText("Lunch");
                img2.setImageResource(R.drawable.tlh);
                myText2.setText("" + "-Fried Chicken\n -Jollof Rice\n-Zobo\n-Time: 12:30pm-1:30pm\n-Location: Hostel(Boys/Girls)");

                //headerS1.setText("Lunch Dining Hall Menu 1");
                imgs.setImageResource(R.drawable.tlsa);
                myTextS1.setText("" + "-Firin Tavuk\n-Jollof Rice\n-Green Salat\n-Kazandibi \n-zobo: 12:30pm-1:30pm\n-Location: School Building:Ground Floor");

                //headerS2.setText("Lunch Dining Hall Menu 2");
                imgss.setImageResource(R.drawable.tlsb);
                myTextS2.setText("" + "-Ezogelin Corba\n-Ciflik Kebap\n-Jollof Rice \n-Meyve\n-Time: 12:30pm-1:30pm\n-Location: School Building:Ground Floor");


                // header3.setText("Dinner");
                img3.setImageResource(R.drawable.td);
                myText3.setText("" + "-Stew\n-White Rice\n-Beans\n-Russian Salad\n-Zobo\n-Meat Suya\n-Time: 6:30pm-7:30pm\n-Location: Hostel(Boys/Girls)"); */
/*

            case "wednesday":
                header.setText("Wednesday Menu");
                //header1.setText("Breakfast");
                img1.setImageResource(R.drawable.wb);
                myText1.setText("" + "-Tea\n-Milk\n-Milo\n-Sugar\n-Bread\n-Jam\n-Blueband\n-Corn Flakes\n-Boiled Yam\n-Liver sauce\n-Time: 7:30am-8:30am\n-Location: Hostel(Boys/Girls)");


                //header2.setText("Lunch Hostel");
                img2.setImageResource(R.drawable.wlh);
                myText2.setText("" + "-Boiled Yam\n-Meat Stew\n-Orange\n-Time: 12:30pm-1:30pm\n-Location: Hostel(Boys/Girls)");


                //headerS1.setText("Lunch Dining Hall Menu 1");
                imgs.setImageResource(R.drawable.wlsa);
                myTextS1.setText("" + "-Mercimek Corba\n-Kuru Fasulye\n-Meat Stew \n-Pirinic Pilavi\nOrange\n-Time: 12:30pm-1:30pm\n-Location: School Building:Ground Floor");

                //headerS2.setText("Lunch Dining Hall Menu 2");
                imgss.setImageResource(R.drawable.wlsb);
                myTextS2.setText("" + "-Mercimek Corba\n-Patlican Kebap\n-Spaghetti \n-Salata\nZobo\n-Time: 12:30pm-1:30pm\n-Location: School Building:Ground Floor");

                //header3.setText("Dinner");
                img3.setImageResource(R.drawable.wd);
                myText3.setText("" + "-White Rice\n-Stew\n-Beans\n-Russian Salad\n-Zobo\n-Meat Suya\n-Time: 6:30pm-7:30pm\n-Location: Hostel(Boys/Girls)");

                break;


            case "thursday":
                header.setText("Thursday Menu");
                // header1.setText("Breakfast");
                img1.setImageResource(R.drawable.thb);
                myText1.setText("" + "-Tea\n-Milk\n-Milo\n-Sugar\n-Bread\n-Jam\n-Blueband\n-Ketchup\n-Potatoe Chips\n-Fried Egg\n-Time: 7:30am-8:30am\n-Location: Hostel(Boys/Girls)");


                //header2.setText("Lunch Hostel");
                img2.setImageResource(R.drawable.thlh);
                myText2.setText("" + "-Fish\n-Jallof Rice\n-Carrot Salad\n-Time: 12:30pm-1:30pm\n-Location: Hostel(Boys/Girls)");

                // headerS1.setText("Lunch Dining Hall Menu 1");
                imgs.setImageResource(R.drawable.thlsa);
                myTextS1.setText("" + "-Yayla Corba\n-Izmir Kofte\n-Makarna\n-Green Salat \n-Pineapple\n-Time: 12:30pm-1:30pm\n-Location: School Building:Ground Floor");

                //  headerS2.setText("Lunch Dining Hall Menu 2");
                imgss.setImageResource(R.drawable.thlsb);
                myTextS2.setText("" + "-Sebze Corbasi\n-Rosto Kofte\n-Jollof Rice \n-Meyve\n-Potatoe pure-Time: 12:30pm-1:30pm\n-Location: School Building:Ground Floor");

                //header3.setText("Dinner");
                img3.setImageResource(R.drawable.thd);
                myText3.setText("" + "-Basmati Rice\n-Pepper Meat\n-Coslow Salad\n-Watermelon\n-Plantain\n-Time: 6:30pm-7:30pm\n-Location: Hostel(Boys/Girls)");

                break;


            case "friday":
                header.setText("Friday Menu");
                //  header1.setText("Breakfast");
                img1.setImageResource(R.drawable.fb);
                myText1.setText("" + "-Tea\n-Milk\n-Milo\n-Bread\n-Sugar\n-Corn Flakes\n-Plantain\n-Krep(Turkish Pancake)\n-Custard\n-Jam\n-Blueband-Time: 7:30am-8:30am\n-Location: Hostel(Boys/Girls)");


                //	header2.setText("Lunch Hostel");
                img2.setImageResource(R.drawable.flh);
                myText2.setText("" + "-Peppered Chicken\n-Fried Rice\n-Watermelon\n-Time: 12:30pm-1:30pm\nLocation: Hostel(Boys/Girls)");

                //  headerS1.setText("Lunch Dining Hall Menu 1");
                imgs.setImageResource(R.drawable.flsa);
                myTextS1.setText("" + "-Sehiriye Corbasi\n-Tavuk Sote\n-Fried Rice\n-American Salat \n-Watermelon-Time: 12:30pm-1:30pm\n-Location: School Building:Ground Floor");

                // headerS2.setText("Lunch Dining Hall Menu 2");
                imgss.setImageResource(R.drawable.flsb);
                myTextS2.setText("" + "-Yayla Corbasi\n-Sebzeli Kebap\n-Sehriyeli Pilav \n Turkish Salat\nZobo-Time: 12:30pm-1:30pm\nLocation: School Building:Ground Floor");


                // header3.setText("Dinner");
                img3.setImageResource(R.drawable.fd);
                myText3.setText("" + "-Poundo Yam\n-Vegetable Soup\n-Egusi Soup\n-Mineral\n-Beef Stew \n-Orange\n-Time: 6:30pm-7:30pm\n-Location: Hostel(Boys/Girls)");

                break;

            case "saturday":
                header.setText("Saturday Menu");
                // header1.setText("Breakfast");
                img1.setImageResource(R.drawable.sb);
                myText1.setText("" + "-Tea\n-Milk\n-Milo\n-Sugar\n-Bread\n-Nutella\n-Honey\nYam Chips\n-Tomatoe Souce\n-Quaker Oats\n-Time: 7:30am-8:30am\n-Location: Hostel(Boys/Girls)");


                //header2.setText("Lunch Hostel");
                img2.setImageResource(R.drawable.slh);
                myText2.setText("" + "-Boiled Meat\n-Vegitable Rice\n-Zobo\n-Time: 12:30pm-1:30pm\nLocation: Hostel(Boys/Girls)");

                //headerS1.setText("Lunch Dining Hall Menu 1");
                imgs.setImageResource(R.drawable.slsa);
                myTextS1.setText("" + "-Domates Corba\n-Patlican Musakka\n-Pilav\n-Mineral \n-Meyve-Time: 12:30pm-1:30pm\n-Location: School Building:Ground Floor");

                //headerS2.setText("Lunch Dining Hall Menu 2");
                imgss.setImageResource(R.drawable.slsb);
                myTextS2.setText("" + "-Paca Corba\n-Tavuk Haslama\n-Soslu Makarna \n Green Salad\n-Time: 12:30pm-1:30pm\nLocation: School Building\n Ground Floor");


                //  header3.setText("Dinner");
                img3.setImageResource(R.drawable.sd);
                myText3.setText("" + "-Fried Rice\n-Meat Peper Soup\n-Coslow Salad\n-Zobo\n-Time: 6:30pm-7:30pm\nLocation: Hostel(Boys/Girls)");

                break;


            case "sunday":
                header.setText("Sunday Menu");
                //  header1.setText("Breakfast");
                img1.setImageResource(R.drawable.sunb);
                myText1.setText("" + "-Tea\n-Milk\n-Milo\n-Sugar\n-Bread\n-Jam\n-Blueband\n-Boiled Potatoe\n-Ketchup\n-Fried Egg\n-Time: 7:30am-8:30am\nLocation: Hostel(Boys/Girls)");


                img2.setImageResource(R.drawable.sunlh);
                myText2.setText("" + "-Fried Fish\n-Jollof Rice\n-Orange\n-Time: 12:30pm-1:30pm\nLocation: Hostel(Boys/Girls)");
                // header2.setText("Lunch");


                img3.setImageResource(R.drawable.sund);
                myText3.setText("" + "-White Macaroni\n-Chicken Suya\n-Stew\n-Zobo\n-Time: 6:30pm-7:30pm\nLocation: Hostel(Boys/Girls)");
                // header3.setText("Dinner");
                myTextS1.setText("");
                headerS1.setText("");
                myTextS2.setText("");
                headerS2.setText("");
                break;*/
