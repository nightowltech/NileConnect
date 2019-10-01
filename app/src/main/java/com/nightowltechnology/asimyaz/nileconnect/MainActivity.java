package com.nightowltechnology.asimyaz.nileconnect;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //private MyPagerAdapter mAdapter;
    private TabLayout mTabLayout;
    private ViewPager mPager;
    private DrawerLayout drawer;
    public static String checker;
    GridView grid_view;
    Intent item1;
    SharedPreferences prefs;
    private boolean mUserSawDrawer = false;
    private static final String FIRST_TIME = "first_time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseMessaging.getInstance().subscribeToTopic("NEWS");


        grid_view = (GridView) findViewById(R.id.gridviewfrag);
        grid_view.setAdapter(new ImageAdapter(this));
        grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        //Intent intent1 = new Intent(MainActivity.this,My_web.class);
                        //.putExtra("url","http://www.ntnumssn.blogspot.com.ng/p/about-us.html?m=1");
                        //startActivity(intent1);
                        Intent intent1 = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(intent1);
                        break;
                    case 1:
                        intent1 = new Intent(MainActivity.this, AdmissionActivity.class);
                        startActivity(intent1);

                        break;
                    case 2:
                        item1= new Intent(MainActivity.this,NewsActivity.class);
                        //item1.putExtra("url","http://www.owsf.org.ng/nileconnect_twitter.html");
                        startActivity(item1);
                        break;

                    case 3:
                        item1 = new Intent(MainActivity.this, DirectoryActivity.class);
                        startActivity(item1);
                        break;
                    case 4:
                        item1 = new Intent(MainActivity.this, ClubsActivity.class);
                        startActivity(item1);
                        break;
                    case 5:
                        item1 = new Intent(MainActivity.this, CalendarActivity.class);
                        startActivity(item1);
                        break;
                    case 6:
                        item1 = new Intent(MainActivity.this, PhotosWebActivity.class);
                        startActivity(item1);
                        break;
                    case 7:
                        intent1 = new Intent(MainActivity.this, DiningActivity.class);
                        startActivity(intent1);
                        break;
                    case 8:
                        intent1 = new Intent(MainActivity.this, SRCActivity.class);
                        startActivity(intent1);
                        break;

                    case 9:
                        intent1 = new Intent(MainActivity.this, StudentInfoSys.class);
                        //intent1.putExtra("url", "http://ntnumssn.blogspot.com.ng/p/blog-page.html?m=1");
                        startActivity(intent1);
                        break;
                    case 10:
                        //item1 = new Intent(MainActivity.this, SportsActivity.class);
                        intent1 = new Intent(MainActivity.this,WebViewActivity.class);
                        intent1.putExtra("url","http://students.nun.edu.ng/sports/");
                        startActivity(intent1);
                        break;
                    case 11:
                        intent1 = new Intent(MainActivity.this, VideosActivity.class);
                        // intent1.putExtra("url","http://ntnumssn.blogspot.com.ng/p/contact-us.html?m=1");
                        startActivity(intent1);
                        break;
                    case 12:
                        intent1 = new Intent(MainActivity.this, CanteenActivity.class);
                        startActivity(intent1);
                        break;

                    case 13:
                        intent1 = new Intent(MainActivity.this,WebViewActivity.class);
                        intent1.putExtra("url","http://105.112.80.25/pms/");
                        startActivity(intent1);
                        break;

                    case 14:
                        intent1 = new Intent(MainActivity.this, DownloadsActivity.class);
                        // intent1.putExtra("url","http://ntnumssn.blogspot.com.ng/p/contact-us.html?m=1");
                        startActivity(intent1);
                        break;

                    case 15:
                        intent1 = new Intent(MainActivity.this, MapsActivity.class);
                        // intent1.putExtra("url","http://ntnumssn.blogspot.com.ng/p/contact-us.html?m=1");
                        startActivity(intent1);
                        break;
                    case 16:
                        intent1 = new Intent(MainActivity.this, EmergencyActivity.class);
                        // intent1.putExtra("url","http://ntnumssn.blogspot.com.ng/p/contact-us.html?m=1");
                        startActivity(intent1);
                        break;

                    case 17:
                        intent1 = new Intent(MainActivity.this, FacebookActivity.class);
                        // intent1.putExtra("url","http://ntnumssn.blogspot.com.ng/p/contact-us.html?m=1");
                        startActivity(intent1);
                        break;

                    case 18:
                        intent1 = new Intent(MainActivity.this, TwitterActivity.class);
                        // intent1.putExtra("url","http://ntnumssn.blogspot.com.ng/p/contact-us.html?m=1");
                        startActivity(intent1);
                        break;

                }

            }
        });

      /*  grid_view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 8:
                        prefs =  getSharedPreferences("Mypref", Context.MODE_APPEND);
                        final SharedPreferences.Editor editor = prefs.edit();
                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());

                        builder.setMessage("reset your favourite timetable ?");

                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                editor.putInt("pos",-1);
                                editor.apply();
                                Toast.makeText(getApplicationContext(),"Your reset is successful now restart Nile Connect !! ", Toast.LENGTH_LONG).show();


                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        AlertDialog alertDialog= builder.create();
                        alertDialog.show();
                        break;
                }
                return false;
            }
        });*/




        /*mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);


        mTabLayout.addTab(mTabLayout.newTab().setText("Timetable"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Home"));
        mTabLayout.addTab(mTabLayout.newTab().setText("VC Message"));

        prefs = getSharedPreferences("orientation", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("pos","grid");
        editor.apply();

        //Notice how the Tab Layout links with the Pager Adapter
        mTabLayout. setupWithViewPager(mPager);


        //Notice how The Tab Layout adn View Pager object are linked
        mTabLayout.setupWithViewPager(mPager);
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mPager.setCurrentItem(1);
 */

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ntnu.edu.ng")));
                Intent i = new Intent(MainActivity.this,SchoolSiteActivity.class);
                startActivity(i);


            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        if(isNetworkConnected()) {
        }
        else{
            Snackbar.make(findViewById(R.id.coordinatorLayout_main), "No internet please connect!!", Snackbar.LENGTH_LONG).show();

        }
        if (!didUserSeeDrawer()) {
            showDrawer();
            markDrawerSeen();
        } else {
            hideDrawer();
        }


    }

    private boolean didUserSeeDrawer() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mUserSawDrawer = sharedPreferences.getBoolean(FIRST_TIME, false);
        return mUserSawDrawer;
    }

    private void markDrawerSeen() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mUserSawDrawer = true;
        sharedPreferences.edit().putBoolean(FIRST_TIME, mUserSawDrawer).apply();
    }


    private void showDrawer() {
        drawer.openDrawer(GravityCompat.START);
    }

    private void hideDrawer() {
        drawer.closeDrawer(GravityCompat.START);
    }




    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
        {
            this.moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        prefs = getSharedPreferences("orientation", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to exit Nileconnect?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog alertDialog= builder.create();
            alertDialog.show();
            return true;
        }
        if (id == R.id.action_aap_info) {
            Intent i = new Intent(MainActivity.this,AppInfo.class);
            startActivity(i);
            return true;
        }
//        if (id == R.id.action_orientation) {
//            if(checker!= "grid") {
//
//                editor.putString("orn","land");
//                editor.apply();
//            }
//            else{
//                editor.putString("orn","grid");
//                editor.apply();
//            }
//        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
        } else if (id == R.id.nav_partners) {
            Intent i = new Intent(MainActivity.this,PartnersActivity.class);
            startActivity(i);

        }
        else if (id == R.id.nav_ann) {
            Intent i = new Intent(MainActivity.this,Announcements.class);
            startActivity(i);

        }
        else if (id == R.id.nav_website) {
            Intent i = new Intent(MainActivity.this,SchoolSiteActivity.class);
            startActivity(i);

        }
        else if (id == R.id.nav_contact_us) {
            Intent i = new Intent(MainActivity.this,ContactusActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_credits) {
            Intent i = new Intent(MainActivity.this,CreditsActivity.class);
            startActivity(i);
        }
        else if (id == R.id.nav_rate_us) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.nightowltechnology.asimyaz.nileconnect")));


        } else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Hello there, Nile Connect App is now available on google playstore" +
                    " click on the link below to download the app https://play.google.com/store/apps/details?id=com.nightowltechnology.asimyaz.nileconnect");
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Nile Connect");
            startActivity(Intent.createChooser(sharingIntent, "Share using"));
        } else if (id == R.id.nav_dev) {
            Intent i = new Intent(MainActivity.this,Nightowl.class);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}/*
class MyPagerAdapter extends FragmentStatePagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //FourthActivity.MyFragment myFragment = FourthActivity.MyFragment.newInstance(position);
        Fragment fragment = null;


        if (position == 0) {

            fragment = new FragmentMyTimetable();

        } else if (position == 1) {
            fragment = new FragmentMain();

        } else if (position == 2) {

            fragment = new FragmentVC();

        }

        return fragment;

    }

    @Override
    public int getCount() {
        return 3;
    }
    } */