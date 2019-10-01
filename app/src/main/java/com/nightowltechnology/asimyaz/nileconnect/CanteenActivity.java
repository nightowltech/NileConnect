package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;

public class CanteenActivity extends  AppCompatActivity {

    RecyclerView CanteenList_Recycler;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Canteen");
        mDatabase.keepSynced(true);
        String s =""+  mDatabase;
        Log.d("mDatabase is: ", "onCreate: "+s);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        CanteenList_Recycler = (RecyclerView) findViewById(R.id.canteen_ID);
        CanteenList_Recycler.hasFixedSize();
        CanteenList_Recycler.setLayoutManager( new LinearLayoutManager(this));


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<CanteenList,CanteenListViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter <CanteenList,CanteenListViewHolder>(
                CanteenList.class,
                R.layout.custom_row_canteeen,
                CanteenListViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(CanteenListViewHolder viewHolder, CanteenList model, int position) {
                viewHolder.setPrice(model.getPrice());
                viewHolder.setName(model.getName());


            }
        };
        CanteenList_Recycler.setAdapter(firebaseRecyclerAdapter);
    }

    public static class CanteenListViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public CanteenListViewHolder(View itemView) {
            super(itemView);


            mView = itemView;
        }

        public void setName(String prod)
        {
            TextView canteen_product = (TextView) mView.findViewById(R.id.canteen_product);
            canteen_product.setText(prod);
        }
        public void setPrice(String price)
        {
            TextView canteen_price = (TextView) mView.findViewById(R.id.canteen_price);
            canteen_price.setText(price);
        }


    }
}
