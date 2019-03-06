package com.example.kostas.reslife.gallery;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.kostas.reslife.R;

public class GalleryActivity extends Activity {
    ViewPager viewPager;
    SwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        adapter = new SwipeAdapter(this);
        viewPager.setAdapter(adapter);


    }


}
