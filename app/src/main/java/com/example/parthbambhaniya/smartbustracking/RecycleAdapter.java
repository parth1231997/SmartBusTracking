package com.example.parthbambhaniya.smartbustracking;

/**
 * Created by bmpar on 1/10/2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by csa on 3/1/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Myholder> {
    List<Model> dataModelArrayList;

    public RecycleAdapter(List<Model> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView txtName,txtEmail,txtContact,txtDob,txtGender,txtHobbies,txtCourse;
        ;

        public Myholder(View itemView) {
            super(itemView);

            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtEmail = (TextView) itemView.findViewById(R.id.txtEmail);
            txtContact = (TextView) itemView.findViewById(R.id.txtContact);
            txtDob = (TextView) itemView.findViewById(R.id.txtDob);
            txtGender = (TextView) itemView.findViewById(R.id.txtGender);
            txtHobbies = (TextView) itemView.findViewById(R.id.txtHobbies);
            txtCourse = (TextView) itemView.findViewById(R.id.txtCourse);
        }
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item,null);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        Model dataModel = dataModelArrayList.get(position);
        holder.txtName.setText(dataModel.getName());
        holder.txtEmail.setText(dataModel.getEmail());
        holder.txtContact.setText(dataModel.getContact());
        holder.txtDob.setText(dataModel.getDob());
        holder.txtGender.setText(dataModel.getGender());
        holder.txtHobbies.setText(dataModel.getHoobies());
        holder.txtCourse.setText(dataModel.getCourse());
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}

