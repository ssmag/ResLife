
package com.example.kostas.reslife.map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.kostas.reslife.R;

public class MapGoToDeree extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_get_started);


        TouchImageView img = new TouchImageView(this);
        img.setImageResource(R.drawable.mapgotoderee);
        img.setMaxZoom(4f);
        setContentView(img);
    }

}
