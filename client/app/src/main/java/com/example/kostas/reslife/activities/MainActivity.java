package com.example.kostas.reslife.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.example.kostas.reslife.R;
import com.example.kostas.reslife.webviews.*;/*
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;*/
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;


public class MainActivity extends Activity {

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    Context applicationContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        applicationContext = getApplicationContext();
        //checkPlayServices();

        FirebaseMessaging.getInstance().subscribeToTopic("test");
        String token = FirebaseInstanceId.getInstance().getToken();


    }

    public void openActivity(View v, Class c) {
        Intent i = new Intent(this, c);
        startActivity(i);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    public void PhiloxeniaWebView(View x) {
        Intent intent = new Intent(this, PhiloxeniaWebView.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    public void NewBlackboardWebView(View x) {
        Intent intent = new Intent(this, BlackBoardWebView.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    public void MyAcgWebView(View x) {
        Intent intent = new Intent(this, MyAcgWebView.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    public void EmergencyContactsBTN(View x) {
        Intent intent = new Intent(this, EmergencyContactsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    public void CalendarBTN(View x) {
        Intent intent = new Intent(this, EventsJSONActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    public void OtherUsefulInfoBTN(View x) {
        Intent intent = new Intent(this, OtherUsefulInfoActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    public void TravellingInGreeceBTN(View x) {
        Intent intent = new Intent(this, TravellingInGreeceActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    public void StayHealthyΑndSafeBTN(View x) {
        Intent intent = new Intent(this, StayHealthyAndSafeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    public void StudyingAtDereeBTN(View x){
        Intent intent = new Intent(this, StudyingAtDereeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    public void LivingInAthensBTN(View x) {
        Intent intent = new Intent(this, LivingInAthensActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    // Check if Google PlayServices is installed in Device or not
  /*  private boolean checkPlayServices() {
        GoogleApiAvailability googleApiInstance = GoogleApiAvailability.getInstance();
        Context context = getApplicationContext();
        int resultCode = googleApiInstance.isGooglePlayServicesAvailable(context);
        // When Play services not found in device
        if (resultCode != ConnectionResult.SUCCESS) {
            if (googleApiInstance.isUserResolvableError(resultCode)) {
                // Show Error dialog to install Play services
                googleApiInstance.getErrorDialog(this,resultCode ,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(
                        applicationContext,
                        "This device doesn't support Play services, App will not work normally",
                        Toast.LENGTH_LONG).show();
               // finish();
            }
            return false;
        }
        return true;
    }*/
}