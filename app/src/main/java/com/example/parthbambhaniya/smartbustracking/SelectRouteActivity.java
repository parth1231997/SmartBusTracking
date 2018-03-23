package com.example.parthbambhaniya.smartbustracking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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
 * Created by Parth-LP on 2/23/2018.
 */

public class SelectRouteActivity extends AppCompatActivity {

    GridView gvselectdata;
    JSONParser jp=new JSONParser();
    JSONObject jo;
    JSONArray jsonArray;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_route);
        gvselectdata=findViewById(R.id.gvselectdata);
        new SelectRouteActivity.SelectAllData().execute();
        gvselectdata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent t1 = new Intent(SelectRouteActivity.this, TimeTableActivity.class);
                    startActivity(t1);
                }
                else if (position == 1) {
                    Intent searchRoute = new Intent(SelectRouteActivity.this, TimeTableActivity.class);
                    startActivity(searchRoute);
                }
                else if (position == 2) {
                    Intent busStop = new Intent(SelectRouteActivity.this, TimeTableActivity.class);
                    startActivity(busStop);
                }
            }
        });
    }
    class SelectAllData extends AsyncTask<String,Void,String>
    {
        String success=null,name[],id[],temp[];

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(SelectRouteActivity.this);
            pd.setMessage("Getting Data..");
            pd.setCancelable(false);
            pd.show();
        }
        @Override
        protected String doInBackground(String... params) {

            List<NameValuePair> nv=new ArrayList<NameValuePair>();
            jo=jp.makeHttpRequest("https://smart-bus-tracking.000webhostapp.com/api/select.php",nv);
            try {
                jsonArray = jo.getJSONArray("user_info");

                name= new String[jsonArray.length()];
                id = new String[jsonArray.length()];

                success=jo.getString("yes");

                for (int i = 0; i < jsonArray.length(); i++) {
                    jo = jsonArray.getJSONObject(i);
                    id[i]=jo.getString("Route_id");
                    name[i]=jo.getString("Route_Name");
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
                    temp[i] = "Route No. "+id[i]+ "\n" +name[i];
                }
                ArrayAdapter<String> adapter = new
                        ArrayAdapter<String>(SelectRouteActivity.this,
                        android.R.layout.simple_dropdown_item_1line, temp);
                gvselectdata.setAdapter(adapter);
            }
            else
            {
                Toast.makeText(SelectRouteActivity.this,"Error in fetching data.",Toast.LENGTH_LONG).show();
            }
        }
    }
}
