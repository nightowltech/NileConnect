package com.nightowltechnology.asimyaz.nileconnect;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.ZoomDensity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;

public class MoodleActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeView;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moodle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        swipeView = (SwipeRefreshLayout)findViewById(R.id.swipe_moodle);
        web = (WebView) findViewById(R.id.webview_moodle);

        final File destinationDir = new File(Environment.getExternalStorageDirectory(), getPackageName());
        if (!destinationDir.exists()) {
            destinationDir.mkdir(); // Don't forget to make the directory if it's not there
        }

        web.setWebViewClient(new myWebClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setBuiltInZoomControls(true);
        web.getSettings().setSupportZoom(true);
        web.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        web.getSettings().setLoadWithOverviewMode(true);


        if(isNetworkConnected()) {
            web.loadUrl("http://www.sis.ntnu.edu.ng:451/portal/my/");

        }
        else{
            web.setVisibility(View.GONE);
            AlertDialog.Builder builder = new AlertDialog.Builder(MoodleActivity.this);
            builder.setMessage("Sorry your network is not connected.");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(MoodleActivity.this,MainActivity.class);
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
                web.loadUrl("http://www.sis.ntnu.edu.ng:451/portal/my/");

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
            Toast.makeText(getApplicationContext(), "Your Internet Connection May not be active Or " + error , Toast.LENGTH_LONG).show();
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            swipeView.setRefreshing(true);

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // This will handle downloading. It requires Gingerbread, though
            DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

            Uri source = Uri.parse(url);
            //return super.shouldOverrideUrlLoading(view, url);
            // Make a new request pointing to the mp3 url
            DownloadManager.Request request = new DownloadManager.Request(source);
            // Use the same file name for the destination
            //File destinationFile = new File (Environment.getExternalStorageDirectory() + "/downloads");
            //request.setDestinationUri(Uri.fromFile(destinationFile));
            // Add it to the manager
            manager.enqueue(request);
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
