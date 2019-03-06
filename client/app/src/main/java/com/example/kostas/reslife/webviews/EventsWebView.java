package com.example.kostas.reslife.webviews;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.kostas.reslife.R;

public class EventsWebView extends Activity {

    WebView w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_events_web_view);

        w = (WebView) findViewById(R.id.events_web_view);
        w.loadUrl("http://mob.students.acg.edu/resevents.php");
        w.getSettings().setLoadWithOverviewMode(true); //sets page to show in full
        w.getSettings().setUseWideViewPort(true);
        w.getSettings().setJavaScriptEnabled(true); //enable javascript in WebView
        w.getSettings().setBuiltInZoomControls(false);//enable zoom
        w.getSettings().setSupportZoom(false);//enable zoom

        w.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) { //keeps user in WV, does not pop up browser

                view.loadUrl(url);
                return false;
            }
        });
    }

    /****ENABLES BACK BUTTON IN WEBVIEW***/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (w.canGoBack()) {
                        w.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public void setUrl(String url) {
        w.loadUrl(url);
    }

}
