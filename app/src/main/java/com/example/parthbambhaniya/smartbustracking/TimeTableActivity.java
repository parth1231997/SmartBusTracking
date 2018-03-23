package com.example.parthbambhaniya.smartbustracking;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Parth-LP on 2/20/2018.
 */

public class TimeTableActivity extends AppCompatActivity {

    GridView gvselectdata;
    JSONParser jp=new JSONParser();
    JSONObject jo;
    JSONArray jsonArray;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        gvselectdata=findViewById(R.id.gvselectdata);
        new TimeTableActivity.SelectAllData().execute();
    }
    class SelectAllData extends AsyncTask<String,Void,String>
    {
        String success=null,time[],timeId[],id[],temp[];

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(TimeTableActivity.this);
            pd.setMessage("Getting Data..");
            pd.setCancelable(false);
            pd.show();
        }
        @Override
        protected String doInBackground(String... params) {

            List<NameValuePair> nv=new ArrayList<NameValuePair>();
            jo=jp.makeHttpRequest("https://smart-bus-tracking.000webhostapp.com/api/selectTime.php",nv);
            try {
                jsonArray = jo.getJSONArray("user_info");

                time= new String[jsonArray.length()];
                timeId = new String[jsonArray.length()];
                id = new String[jsonArray.length()];

                success=jo.getString("yes");

                for (int i = 0; i < jsonArray.length(); i++) {
                    jo = jsonArray.getJSONObject(i);
                    timeId[i]=jo.getString("Time_Id");
                    id[i]=jo.getString("Route_id");
                    time[i]=jo.getString("Time_Details");
                }
                temp = new String[time.length];
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return success;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            pd.dismiss();

            if(s.equals("1"))
            {
                for (int i = 0; i < time.length; i++) {
                    temp[i] = "Route Time. " +time[i] +" PM";
                }
                ArrayAdapter<String> adapter = new
                        ArrayAdapter<String>(TimeTableActivity.this,
                        android.R.layout.simple_dropdown_item_1line, temp);
                gvselectdata.setAdapter(adapter);
            }
            else
            {
                Toast.makeText(TimeTableActivity.this,"Error in fetching data.",Toast.LENGTH_LONG).show();
            }
        }
    }
}
