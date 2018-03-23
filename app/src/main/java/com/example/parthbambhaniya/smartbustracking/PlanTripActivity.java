package com.example.parthbambhaniya.smartbustracking;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parthbambhaniya.smartbustracking.JSONParser;
import com.example.parthbambhaniya.smartbustracking.R;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Parth-LP on 2/23/2018.
 */

public class PlanTripActivity extends AppCompatActivity {
    Spinner s1, s2;
    ArrayList<String> list1;
    ArrayList<String> list2;
    JSONParser jp=new JSONParser();
    JSONObject jo;
    JSONArray jsonArray;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_trip);
        s1  = findViewById(R.id.spinner);
        s2 =  findViewById(R.id.spinner2);
        new PlanTripActivity.SelectAllData().execute();
    }
    class SelectAllData extends AsyncTask<String,Void,String>
    {
        String success=null,name[],id[],temp[];

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(PlanTripActivity.this);
            pd.setMessage("Getting Data..");
            pd.setCancelable(false);
            pd.show();
        }
        @Override
        protected String doInBackground(String... params) {

            List<NameValuePair> nv=new ArrayList<NameValuePair>();
            jo=jp.makeHttpRequest("https://smart-bus-tracking.000webhostapp.com/api/selectStop.php",nv);
            try {
                jsonArray = jo.getJSONArray("user_info");

                name= new String[jsonArray.length()];
                id = new String[jsonArray.length()];

                success=jo.getString("yes");

                for (int i = 0; i < jsonArray.length(); i++) {
                    jo = jsonArray.getJSONObject(i);
                    id[i]=jo.getString("Stop_id");
                    name[i]=jo.getString("Stop_Name");
                }
                temp = new String[name.length];
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
                for (int i = 0; i < name.length; i++) {
                    temp[i] = name[i];
                }
                ArrayAdapter<String> adapter = new
                        ArrayAdapter<String>(PlanTripActivity.this,
                        android.R.layout.simple_dropdown_item_1line, temp);
                s1.setAdapter(adapter);
                s2.setAdapter(adapter);
            }
            else
            {
                Toast.makeText(PlanTripActivity.this,"Error in fetching data.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
