package com.example.youngmin_mac.assignment5;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngmin-mac on 2018. 4. 11..
 */

public class APITask extends AsyncTask<String,Integer,List<Earthquake>> {
    @Override
    protected List<Earthquake> doInBackground(String... strings) {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();
            InputStream stream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();

            return makeList(sb.toString());

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (urlConnection != null) {
                try {
                    urlConnection.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }

    private List<Earthquake> makeList(String data)
    {
        List<Earthquake> list = new ArrayList<Earthquake>();
        try {
            JSONObject jsonResponse = new JSONObject(data);

            JSONArray earthquakes = jsonResponse.getJSONArray("features");
            for(int i=0;i<earthquakes.length();i++){
                Earthquake e = new Earthquake();
                JSONObject earthquake = earthquakes.getJSONObject(i);
                JSONObject properties = earthquake.getJSONObject("properties");
                e.setTitle(properties.getString("title"));
                e.setUrl(properties.getString("url"));
                e.setTime(properties.getString("time"));
                list.add(e);
            }

            }//end for
        catch (JSONException e1) {
            e1.printStackTrace();
        }

        return list;
    }
}
