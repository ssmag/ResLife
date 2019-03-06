package com.example.kostas.reslife.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.kostas.reslife.R;

public class PreDepartureGuideActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pre_departure_guide);
    }
    public void PreDepartureChecklistBTN(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }
    public void BuyingBooksBTN(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }
    public void HealthBTN(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }
    public void SafetyBTN(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }
    public void PackingBTN(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }
}
