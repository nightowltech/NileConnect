package com.nightowltechnology.asimyaz.nileconnect;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Announcements extends AppCompatActivity {
    RecyclerView News;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Announcements");
        mDatabase.keepSynced(true);
        News = (RecyclerView) findViewById(R.id.announcements);
        News.hasFixedSize();
        News.setLayoutManager(new LinearLayoutManager(this));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<AnnoucementsList, AnnoucementsListViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<AnnoucementsList, AnnoucementsListViewHolder>(
                AnnoucementsList.class,
                R.layout.custom_row_announcement,
                AnnoucementsListViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(AnnoucementsListViewHolder viewHolder, AnnoucementsList model, int position) {
                viewHolder.setTitle(model.getTitle());
                viewHolder.setContent(model.getContent());


            }
        };
        News.setAdapter(firebaseRecyclerAdapter);
    }


    public static class AnnoucementsListViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public AnnoucementsListViewHolder(View itemView) {
            super(itemView);


            mView = itemView;
        }

        public void setTitle(String t) {
            TextView post_title = (TextView) mView.findViewById(R.id.custom_title);
            post_title.setText(t);
        }

        public void setContent(String c) {
            TextView content = (TextView) mView.findViewById(R.id.content);
            content.setText(c);
        }

    }
}




