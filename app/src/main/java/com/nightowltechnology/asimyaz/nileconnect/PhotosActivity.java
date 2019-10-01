package com.nightowltechnology.asimyaz.nileconnect;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by asimbyazid on 09/02/2016.
 */
public class PhotosActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeView;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        swipeView = (SwipeRefreshLayout)findViewById(R.id.swipe_gallery);
        web = (WebView) findViewById(R.id.webview_gallery);
        swipeView.setDistanceToTriggerSync(23);

        final File destinationDir = new File(Environment.getExternalStorageDirectory(), getPackageName());
        if (!destinationDir.exists()) {
            destinationDir.mkdir(); // Don't forget to make the directory if it's not there
        }

        web.setWebViewClient(new PhotosActivity.myWebClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        if(isNetworkConnected()) {
            web.loadUrl("http://nileuniversity.edu.ng/photos/");

        }
        else{
            web.setVisibility(View.GONE);
            AlertDialog.Builder builder = new AlertDialog.Builder(PhotosActivity.this);
            builder.setMessage("Sorry your network is not connected.");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(PhotosActivity.this,MainActivity.class);
                    startActivity(i);

                }
            });

            AlertDialog alertDialog= builder.create();
            alertDialog.show();

        }




        swipeView.setColorSchemeColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.colorPrimaryDark));
        swipeView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {


            @Override
            public void onRefresh() {
                swipeView.setRefreshing(true);
                // web.loadUrl("http://owsf.org.ng/nileconnect_twitter.html");
                web.loadUrl("http://nileuniversity.edu.ng/photos/");

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        swipeView.setRefreshing(false);
                    }
                }, 20000);

            }

        });



    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
    public class myWebClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            swipeView.setRefreshing(false);
            web.setVisibility(View.VISIBLE);
        }
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error){
            //Your code to do
            Toast.makeText(getApplicationContext(), "Your Internet Connection May not be active or " + error , Toast.LENGTH_LONG).show();
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            swipeView.setRefreshing(true);

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);

            view.loadUrl("about:blank");
        }

    }

    @Override
    public boolean onKeyDown ( int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
            web.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

/*AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        String[] gallery =
                {
                        "International Friendship Festival","Park & Zoo Picnic","Nile Laboratories",
                        "NESA: Nigerian Economic Students Association","Nile students Participate in NTICF Charity event 1","NTIC Foundation Stationaries Program with Nile Students",
                        "Nile Places","General Nile Moments","MSSN: Omrah trip",
                        "Bussiness club visit to Ufuk Dialog","Home Visit to Parents","Sports Activities","Life OnCampus","Park & Zoo Outing 100 level","Park & Zoo Outing 400 level"};
        android.widget.ListAdapter gAdapter = new PhotosAdapter(this,gallery);
        ListView myDining = (ListView) findViewById(R.id.plistId);
        myDining.setAdapter(gAdapter);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        myDining.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch(position){
                    case 0:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                       // intent.putExtra("url","http://owsf.org.ng/gallery/fest/index.html");
                        intent.putExtra("url","         "http://students.nun.edu.ng/gallery\");\n");
                        startActivity(intent);
                        break;

                    case 1:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                        intent.putExtra("url", "http://owsf.org.ng/gallery/park1/index.html");
                        startActivity(intent);

                        break;
                    case 2:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                        intent.putExtra("url", "http://owsf.org.ng/gallery/lab/index.html");
                        startActivity(intent);
                        break;
                    case 3:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                        intent.putExtra("url", "http://owsf.org.ng/gallery/nesa/index.html");
                        startActivity(intent);
                        break;
                    case 4:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                        intent.putExtra("url", "http://owsf.org.ng/gallery/nticf1/index.html");
                        startActivity(intent);
                        break;
                    case 5:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                        intent.putExtra("url", "http://owsf.org.ng/gallery/nticf2/index.html");
                        startActivity(intent);
                        break;
                    case 6:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                        intent.putExtra("url", "http://owsf.org.ng/gallery/place/index.html");
                        startActivity(intent);

                        break;
                    case 7:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                        intent.putExtra("url", "http://owsf.org.ng/gallery/moments/index.html");
                        startActivity(intent);
                        break;
                    case 8:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                        intent.putExtra("url", "http://owsf.org.ng/gallery/omrah/index.html");
                        startActivity(intent);
                        break;
                    case 9:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                        intent.putExtra("url", "http://owsf.org.ng/gallery/buss/index.html");
                        startActivity(intent);
                        break;
                    case 10:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                        intent.putExtra("url", "http://owsf.org.ng/gallery/visit/index.html");
                        startActivity(intent);
                        break;
                    case 11:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                        intent.putExtra("url", "http://owsf.org.ng/gallery/sports/index.html");
                        startActivity(intent);
                        break;
                    case 12:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                        intent.putExtra("url", "http://owsf.org.ng/gallery/park1/index.html");
                        startActivity(intent);
                        break;
                    case 13:
                        intent= new Intent(PhotosActivity.this,PhotosWebActivity.class);
                        intent.putExtra("url", "http://owsf.org.ng/gallery/park2/index.html");
                        startActivity(intent);
                        break;




                }
            }
        });
    }
}
*/