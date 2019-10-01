package com.nightowltechnology.asimyaz.nileconnect;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * Created by asimbyazid on 09/02/2016.
 */
public class DirectoryActivity extends AppCompatActivity {

    RecyclerView mBloglist;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Directory");
        mDatabase.keepSynced(true);
        String s =""+  mDatabase;
        Log.d("mDatabase is: ", "onCreate: "+s);

        mBloglist = (RecyclerView) findViewById(R.id.listId);
        mBloglist.hasFixedSize();
        mBloglist.setLayoutManager( new LinearLayoutManager(this));


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<MDirectory,MDirectoryViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter <MDirectory, MDirectoryViewHolder>(
                MDirectory.class,
                R.layout.custom_row2,
                MDirectoryViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(MDirectoryViewHolder viewHolder, MDirectory model, int position) {
                viewHolder.setName(model.getName());
                //viewHolder.setPost(model.getPost());
                //viewHolder.setEmail(model.getEmail());
                viewHolder.setRoomnumber(model.getRoomnumber());
                //viewHolder.setTelephone(model.getTelephone());

                viewHolder.setCropimg(getApplicationContext(),model.getCropimg());


            }
        };
        mBloglist.setAdapter(firebaseRecyclerAdapter);
    }

    public static class MDirectoryViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public MDirectoryViewHolder(View itemView) {
            super(itemView);


            mView = itemView;
        }

        public void setName(String name)
        {
            TextView post_title = (TextView) mView.findViewById(R.id.custom_name);
            post_title.setText(name);
        }
       /* public void setPost(String post)
        {
            TextView post_title = (TextView) mView.findViewById(R.id.custom_textview2);
            post_title.setText(post);
        }

        public void setEmail(String email)
        {
            TextView post_title = (TextView) mView.findViewById(R.id.custom_textview_email);
            post_title.setText(email);
        }
        public void setTelephone(String email)
        {
            TextView post_title = (TextView) mView.findViewById(R.id.custom_textviewtel);
            post_title.setText(email);
        }*/

        public void setRoomnumber(String room)
        {
            TextView post_text = (TextView) mView.findViewById(R.id.custom_textview2);
            post_text.setText(room);
        }
        public void setCropimg(Context ctx, String m_image)
        {
            ImageView post_img = (ImageView) mView.findViewById(R.id.custom_img2);
            Picasso.with(ctx).load(m_image).into(post_img);

        }

    }


    /*
    public Integer[] image_id = {
            R.drawable.vc,R.drawable.dvc,R.drawable.dvcadmin,R.drawable.default_contact,R.drawable.diracademic,
            R.drawable.deanpostgrad,R.drawable.deanfnas,R.drawable.deaneng,R.drawable.deanart,
            R.drawable.default_contact,R.drawable.hodbusadmin,R.drawable.hodchem,R.drawable.hodecons,
            R.drawable.hodeee,R.drawable.hodenglish,R.drawable.hodpol,R.drawable.default_contact,R.drawable.default_contact,
            R.drawable.pr,
    };
    final String[] names = {
            "Prof. Dr. Huseyin Sert M.D","Prof. Mehmet Yilmaz","Assoc. Prof. Dr.Steve Adeshina",
            "Mr. Kasim Ozkulluk","Assoc Prof Dr. S.E Abdullahi","Dr. Mehmet Fatih Yasar","Prof. Dr. Musa Muhammed",
            "Dr. Gokhan Koyunlu","Prof. Dr. Huseyin Kalyoncu","Prof N.Nnanna Agwu","Dr. Abdulrahman Isik","Dr. Sherali Tursunbandalov",
            "Dr. Gylych Jelilov","Mr. Ismail Farouk Labaran","Dr. Onyebuchi James Ile","PhD.c Levent Demiroglu","Dr Boun Alonge","Dr B. Babagana",
            "Mr. Adem Arslan"
    };
    private String info[]=
            {"Room: 311\nThird Floor","Room: 307\nThird Floor","Room: 305\nThird Floor","Room: 312\nThird Floor","Room: 315\nThird Floor",
                    "Room: 304\nThird Floor","Room: 103\nFirst Floor","Room: 104\nFirst Floor","Room: 231\nSecond Floor","Room: 105\nFirst Floor",
                    "Room: 222\nSecond Floor","Room: 230\nSecond Floor","Room: 111\nFirst Floor","Room: 229\nSecond Floor","Room: 228\nSecond Floor",
                    "Room: 134\nFirst Floor","Room: 101\nFirst Floor",
                    "Room: 106\nFirst Floor"
    };
    private String room[]=
            {"Room: 311","Room: 307","Room: 305","Room: 312","Room: 315",
                    "Room: 304","Room: 103","Room: 104","Room: 231","Room: 105",
                    "Room: 222","Room: 106","Room: 230","Room: 111","Room: 229","Room: 228","Room: 134","Room: 101",
                    "Room: 106"

            };
    TextView text1,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
       // img =(ImageView) findViewById(R.id.Dialog_img1);

        //This String is a reference to the dialog fragment


        android.widget.ListAdapter dirAdapter = new DirectoryAdapter(this,names);
        ListView myDirListView = (ListView) findViewById(R.id.listId);
        myDirListView.setAdapter(dirAdapter);

        final Dialog dialog = new Dialog(DirectoryActivity.this);
        dialog.setContentView(R.layout.fragment_dir);


        //dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
        //dialog.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.staffs);
        text1 = (TextView)dialog.findViewById(R.id.Dialog_txt1);
        text2 = (TextView)dialog.findViewById(R.id.Dialog_txt2);

        final ImageView image = (ImageView) dialog.findViewById(R.id.Dialog_img1);
        myDirListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        image.setImageResource(image_id[position]);
                        dialog.setTitle(names[position]);
                        text1.setText(room[position]);
                        //text2.setText("");
                        dialog.show();


            }
        });
    }

*/
}