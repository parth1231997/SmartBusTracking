package com.example.parthbambhaniya.smartbustracking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Parth Bambhaniya on 9/30/2017.
 */

public class HomeActivity extends AppCompatActivity
{
    DatabaseHelper dbHelper;
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String [] nameList={"Select Route",
                                        "Search Route",
                                        "Bus Stop",
                                        "Track Bus",
                                        "Time Table",
                                        "Active GPS",
                                        "Find Me",
                                        "Plan Trip",
                                        "Search Place",
                                        "Notification"
                                        };
    public static int [] imageList={R.drawable.route_1,
                                    R.drawable.direction,
                                    R.drawable.bus_stop,
                                    R.drawable.icon,
                                    R.drawable.time_table,
                                    R.drawable.gps,
                                    R.drawable.map,
                                    R.drawable.plan_trip,
                                    R.drawable.placeholder,
                                    R.drawable.alarm,
                                    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        CustomAdapter adapter = new CustomAdapter(HomeActivity.this, imageList, nameList);
        gv = (GridView)findViewById(R.id.gridView);
        gv.setAdapter(adapter);
        gv.setAdapter(new CustomAdapter(this,imageList, nameList));
        dbHelper = new DatabaseHelper(this);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent selectRoute = new Intent(HomeActivity.this, SelectRouteActivity.class);
                    startActivity(selectRoute);
                }
                else if (position == 1) {
                    Intent searchRoute = new Intent(HomeActivity.this, SearchRouteActivity.class);
                    startActivity(searchRoute);
                }
                else if (position == 2) {
                    Intent busStop = new Intent(HomeActivity.this, BusStopActivity.class);
                    startActivity(busStop);
                }
                else if (position == 3) {
                    Intent trackBus= new Intent(HomeActivity.this, TrackBusActivity.class);
                    startActivity(trackBus);
                }
                else if (position == 4) {
                    Intent timeTable= new Intent(HomeActivity.this, TimeTableActivity.class);
                    startActivity(timeTable);
                }
                else if (position == 5) {
                    Intent activeGPS = new Intent(HomeActivity.this, ActiveGpsActivity.class);
                    startActivity(activeGPS);
                }
                else if (position == 6) {
                    Intent findMe = new Intent(HomeActivity.this, FindMeActivity.class);
                    startActivity(findMe);
                }
                else if (position == 7) {
                    Intent planTrip= new Intent(HomeActivity.this, PlanTripActivity.class);
                    startActivity(planTrip);
                }
                else if (position == 8) {
                    Intent searchPlace= new Intent(HomeActivity.this, SearchPlaceActivity.class);
                    startActivity(searchPlace);
                }
                else if (position == 9) {
                    Intent notification= new Intent(HomeActivity.this, NotificationActivity.class);
                    startActivity(notification);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sign_up:
                callRegister();
                break;
            case R.id.action_sign_in:
                callLogin();
                break;
            case R.id.action_sign_out:
                Toast.makeText(getApplicationContext(), "Successfully logout", Toast.LENGTH_SHORT).show();
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    public void callRegister()
    {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }
    public void callLogin()
    {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

}
