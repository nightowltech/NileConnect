package com.nightowltechnology.asimyaz.nileconnect;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MagazineInfoActivity extends AppCompatActivity {

    RecyclerView mMagazine;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine_info);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Magazine");
        mDatabase.keepSynced(true);
        String s = "" + mDatabase;
        Log.d("mDatabase is: ", "onCreate: " + s);

        mMagazine = (RecyclerView) findViewById(R.id.mag);
        mMagazine.hasFixedSize();
        mMagazine.setLayoutManager(new LinearLayoutManager(this));


        mMagazine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<MagazineList, MagazineViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<MagazineList,  MagazineViewHolder>(
                MagazineList.class,
                R.layout.custom_row_magazines,
                MagazineViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(MagazineViewHolder viewHolder, MagazineList model, int position) {
                viewHolder.setIssue(model.getIssue());
                viewHolder.setImage(getApplicationContext(), model.getImage());


            }
        };
        mMagazine.setAdapter(firebaseRecyclerAdapter);
    }

    public static class MagazineViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public MagazineViewHolder(View itemView) {
            super(itemView);


            mView = itemView;
        }

        public void setIssue(String i) {
            TextView myIssue = (TextView) mView.findViewById(R.id.custom_textview_mag);
            myIssue.setText(i);
        }


        public void setImage(Context ctx, String p) {
            ImageView mag_img = (ImageView) mView.findViewById(R.id.custom_img_mag);
            Picasso.with(ctx).load(p).resize(120,150).into(mag_img);

        }

    }
}