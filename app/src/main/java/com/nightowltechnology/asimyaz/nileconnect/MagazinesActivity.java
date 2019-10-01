package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MagazinesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazines);
        //ListView v;
        //v = (ListView)findViewById(R.id.listId)

        String[] magazine ={"Nile Convocation 2015","Nile News ","Nile News Issue 1",
							"Nile News Issue 2","Nile News Issue 3","Nile News Issue 4",
                            "Nile News Issue 5","Nile News Issue 6","Nile News Issue 7"};
        android.widget.ListAdapter mAdapter = new MagazineAdapter(this,magazine);
        ListView myMagazine = (ListView) findViewById(R.id.mlistId);
        myMagazine.setAdapter(mAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        myMagazine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch(position){
                    case 0:
					//Nile convocation magazine
                        intent= new Intent(MagazinesActivity.this,MagazineWebActivity.class);
						intent.putExtra("url", "https://www.yumpu.com/en/embed/view/LXYgmCqhAhbc2LKA");
                        startActivity(intent);
                        break;


                    case 1:
					//issue 0
                        intent= new Intent(MagazinesActivity.this,MagazineWebActivity.class);
                        intent.putExtra("url", "https://www.yumpu.com/en/embed/view/SpIQFZqIAuLrANok");
                        startActivity(intent);
                        break;


                    case 2:
					//issue 1
                        intent= new Intent(MagazinesActivity.this,MagazineWebActivity.class);
                        intent.putExtra("url", "https://www.yumpu.com/en/embed/view/AX5oLmDBnOCJ8z4M");
                        startActivity(intent);
                        break;


                    case 3:
					//issue 2
                        intent= new Intent(MagazinesActivity.this,MagazineWebActivity.class);
                        intent.putExtra("url", "https://www.yumpu.com/en/embed/view/1a01pHaaV2S3c09X");
                        startActivity(intent);
                        break;


                    case 4:
					//issue 3
                        intent= new Intent(MagazinesActivity.this,MagazineWebActivity.class);
                        intent.putExtra("url", "https://www.yumpu.com/en/embed/view/c1aUTKK4ybESXRFT");
                        startActivity(intent);
                        break;


                    case 5:
					//issue 4
                        intent= new Intent(MagazinesActivity.this,MagazineWebActivity.class);
                        intent.putExtra("url", "https://www.yumpu.com/en/embed/view/uJmNHixHNQbpmDwt");
                        startActivity(intent);
                        break;


                    case 6:
					//issue 5
                        intent= new Intent(MagazinesActivity.this,MagazineWebActivity.class);
                        intent.putExtra("url", "https://www.yumpu.com/en/embed/view/8brQ1GgRptH48E60");
                        startActivity(intent);
                        break;


                    case 7:
					//issue 6
                        intent= new Intent(MagazinesActivity.this,MagazineWebActivity.class);
                        intent.putExtra("url", "https://www.yumpu.com/en/embed/view/m3vLjDnThTBUflVj");
                        startActivity(intent);
                        break;
					case 8:
					//issue 7
                        intent= new Intent(MagazinesActivity.this,MagazineWebActivity.class);
                        intent.putExtra("url", "https://www.yumpu.com/en/embed/view/m3vLjDnThTBUflVj");
                        startActivity(intent);
                        break;


                   /* case 9:
                    //issue 8
                    intent= new Intent(MagazinesActivity.this,WebViewActivity.class);
                    intent.putExtra("url", "https://www.yumpu.com/en/embed/view/t3rELInWwZ4TDv9S");
                    startActivity(intent);
                    break;

                    case 10:
                        //issue 9
                        intent= new Intent(MagazinesActivity.this,WebViewActivity.class);
                        intent.putExtra("url", "https://www.yumpu.com/en/embed/view/rJn1WPQyMG9R5VmH");
                        startActivity(intent);
                        break;
                    case 11:
                        //nile convocation 2015
                        intent= new Intent(MagazinesActivity.this,WebViewActivity.class);
                        intent.putExtra("url", "https://www.yumpu.com/en/embed/view/VhR6kS7ePQ7UPDKa");
                        startActivity(intent);
                        break;*/
                }
            }
        });
    }
}
