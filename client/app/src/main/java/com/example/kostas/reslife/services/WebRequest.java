package com.example.kostas.reslife.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Melpi on 6/28/2016.
 */

public class WebRequest {
    static String response = null;
    public final static int GETRequest = 1;
    public final static int POSTRequest = 2;

    public WebRequest() {

    }

    public String makeWebServiceCall(String url, int requestmethod) {
        return this.makeWebServiceCall(url,requestmethod,null);
    }

    public String makeWebServiceCall(String urladdress, int requestmethod, HashMap<String, String> params) {
        URL url;
        String response = "";
        try {
            url = new URL(urladdress);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            if (requestmethod == POSTRequest) {
                conn.setRequestMethod("POST");
            } else if (requestmethod == GETRequest) {
                conn.setRequestMethod("GETRequest");
            }

            if (params != null) {
                OutputStream ostream = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(ostream, "UTF-8"));
                StringBuilder requestresult = new StringBuilder();
                boolean first = true;
                for (Map.Entry<String,String> entry : params.entrySet()) {
                    if (first) {
                        first = false;
                    } else {
                        requestresult.append("&");
                        requestresult.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                        requestresult.append("=");
                        requestresult.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    }
                }

                writer.write(requestresult.toString());

                writer.flush();
                writer.close();
                ostream.close();

            }

            int requestresponsecode = conn.getResponseCode();

            if (requestresponsecode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                while ((line = br.readLine()) != null) {
                    response += line;
                }
            } else {
                response = "";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
