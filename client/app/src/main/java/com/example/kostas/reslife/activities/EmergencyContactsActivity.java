package com.example.kostas.reslife.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.kostas.reslife.R;

public class EmergencyContactsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_emergency_contacts);
    }

    public void MenuR2(View v) {
        openOptionsMenu();
    }

    public void CallR1(View v){
        Intent CallIntent1=new Intent(Intent.ACTION_DIAL);
        CallIntent1.setData(Uri.parse("tel:+306946569295"));
        startActivity(CallIntent1);
    }

    public void CallR2(MenuItem item){
        Intent CallIntent2=new Intent(Intent.ACTION_DIAL);
        CallIntent2.setData(Uri.parse("tel:+306942862469"));
        startActivity(CallIntent2);
    }

    public void WhatsAppR2(MenuItem item){
        Intent WhatsApp = new Intent(Intent.ACTION_SENDTO);
        String number = "+306942862469";
        String smsNumber = "sms:" + number;
        WhatsApp.setData(Uri.parse(smsNumber));
        if (appInstalled("com.whatsapp")) {
            WhatsApp.setPackage("com.whatsapp");
            startActivity(WhatsApp);
        } else {
            Toast.makeText(getApplicationContext(),"You do not have WhatsApp Installed on your phone", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean appInstalled(String uri) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        }
        catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_call_r2, menu);

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
