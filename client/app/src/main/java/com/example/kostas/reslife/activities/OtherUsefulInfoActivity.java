package com.example.kostas.reslife.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.example.kostas.reslife.R;
import com.example.kostas.reslife.gallery.GalleryActivity;

public class OtherUsefulInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_other_useful_info);
    }
    public void PlacesOfWorshipBTN(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }
    public void GreekKeyWordsBTN(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }
    public void CommonInternationalConversationsBTN(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }
    public void ContactUsBTN(View x) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    public void GalleryBTN(View x) {

        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
        overridePendingTransition(R.animator.anim1, R.animator.anim2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_otherusefulinfo, menu);
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
