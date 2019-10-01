package com.nightowltechnology.asimyaz.nileconnect;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class Zooming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zooming);

        final TouchImageView img = new TouchImageView(this);




        Picasso.with(Zooming.this).load ("http://www.viraheinz.pitt.edu/sites/default/files/uploads/Images/Preretreat/Goal.jpg").into(new Target() {
            @Override
            public void onBitmapLoaded (final Bitmap bitmap,
                                        final Picasso.LoadedFrom loadedFrom) {
                img.setImageBitmap (bitmap);
                img.setMaxZoom(4f);
                setContentView(img);
            }

            @Override
            public void onBitmapFailed (final Drawable drawable) {
                Log.d("Failure", "Failed");
            }

            @Override
            public void onPrepareLoad (final Drawable drawable) {
                img.setImageDrawable (drawable);
            }
        });
        img.setMaxZoom(4f);
        setContentView(img);
    }
}
