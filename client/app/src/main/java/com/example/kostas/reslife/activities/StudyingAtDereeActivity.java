package com.example.kostas.reslife.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.example.kostas.reslife.R;

public class StudyingAtDereeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_studying_at_deree);
    }
    public void PreDepartureGuide(View x) {

        Intent intent = new Intent(this, PreDepartureGuideActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }
    public void ArrivalChecklist(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    public void CampusServices(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }
    public void BuyingBooks(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }
    public void RegistrationGrades(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }
    public void ResidencePermit(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_studyingatderee, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
