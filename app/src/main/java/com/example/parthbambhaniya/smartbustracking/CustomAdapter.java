package com.example.parthbambhaniya.smartbustracking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Parth Bambhaniya on 10/2/2017.
 */

public class CustomAdapter extends BaseAdapter
{
    //public int position;
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(HomeActivity mainActivity,int[] imageList,String[] nameList) {
        // TODO Auto-generated constructor stub
        result = nameList;
        imageId = imageList;
        context = mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class Holder
    {
        TextView text_title;
        ImageView image_title;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup)
    {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.grid_item_layout, null);
        holder.image_title = (ImageView) rowView.findViewById(R.id.grid_item_image);
        holder.text_title = (TextView) rowView.findViewById(R.id.grid_item_title);

        holder.text_title.setText(result[position]);
        holder.image_title.setImageResource(imageId[position]);

        /*rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToTimeTable(view);
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });*/

        return rowView;
    }

    private void goToTimeTable(View view) {
        Intent i = new Intent(view.getContext(),RegisterActivity.class);
    }


}
