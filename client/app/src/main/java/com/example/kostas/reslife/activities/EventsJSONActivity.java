package com.example.kostas.reslife.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.kostas.reslife.R;
import com.example.kostas.reslife.services.WebRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class EventsJSONActivity extends ListActivity {

    private static String url = "http://mob.students.acg.edu/json3.php";

    public static final String TAG_EVENT_INFO = "eventsinfo";
    public static final String TAG_ID = "id";
    public static final String TAG_TITLE = "title";
    public static final String TAG_DATE = "date";
    public static final String TAG_TIME = "time";
    public static final String TAG_TIME_END = "time_end";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_json);

        new GetEvents().execute();
    }

     class GetEvents extends AsyncTask<Void,Void,Void> {
        ArrayList<HashMap<String,String>> eventList;
        ProgressDialog proDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            proDialog = new ProgressDialog(EventsJSONActivity.this);
            Log.d("prodialog: ","Setting Message.");
            proDialog.setMessage("Please wait...");
            Log.d("prodialog: ","Setting cancellable.");
            proDialog.setCancelable(false);
            Log.d("prodialog: ","Showing...");
            proDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            WebRequest webreq = new WebRequest();
            String url = "http://mob.students.acg.edu/json3.php";
            String jsonStr = webreq.makeWebServiceCall(url,WebRequest.POSTRequest);

            Log.d("Response: ", "> " + jsonStr);

            eventList = ParseJSON(jsonStr);

            return null;
        }

        @Override
        protected void onPostExecute(Void requestresult) {
            super.onPostExecute(requestresult);

            if (proDialog.isShowing()) {
                proDialog.dismiss();
                Log.d("prodialog: ","dismissing dialog.");
            }

            Log.d("Listadapter: ", "eventList: " + eventList.toString());
            ListAdapter adapter = new SimpleAdapter(
                    EventsJSONActivity.this,eventList,
                    android.R.layout.simple_list_item_1,
                    new String[] {TAG_ID, TAG_TITLE, TAG_DATE, TAG_TIME, TAG_TIME_END},
                    new int[] {R.id.id,R.id.title,R.id.date,R.id.time,R.id.time_end});
            Log.d("Listadapter: ","data fed");
            ListView lv = (ListView)findViewById(android.R.id.list);
            lv.setAdapter(adapter);
            Log.d("Listadapter: ",adapter.getCount() + " items set");

        }


        private ArrayList<HashMap<String,String>> ParseJSON(String json) {

            if (json != null) {
                try {
                    ArrayList<HashMap<String,String>> eventList = new ArrayList<>();
                    JSONObject jsonObj = new JSONObject(json);

                    JSONArray events = jsonObj.getJSONArray(TAG_EVENT_INFO);

                    for (int i = 0; i < events.length(); i++) {
                        JSONObject j = events.getJSONObject(i);

                        String id = j.getString(TAG_ID);
                        String title = j.getString(TAG_TITLE);
                        String date = j.getString(TAG_DATE);
                        String time = j.getString(TAG_TIME);
                        String time_end = j.getString(TAG_TIME_END);

                        HashMap<String,String> event = new HashMap<String,String>();

                        event.put(TAG_ID,id);
                        event.put(TAG_TITLE,title);
                        event.put(TAG_DATE,date);
                        event.put(TAG_TIME,time);
                        event.put(TAG_TIME_END,time_end);

                        /*event.put(TAG_ID,"id");
                        event.put(TAG_TITLE,"title");
                        event.put(TAG_DATE,"date");
                        event.put(TAG_TIME,"time");
                        event.put(TAG_TIME_END,"time_end");*/

                        eventList.add(event);
                    }
                    Log.d("EventList > ", eventList.toString());
                    return eventList;

                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            } else {
                Log.e("ServiceHandler", "No data received from HTTP Request");
                return null;
            }
        }
    }


}