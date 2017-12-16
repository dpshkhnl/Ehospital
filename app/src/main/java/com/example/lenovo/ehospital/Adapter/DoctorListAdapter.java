package com.example.lenovo.ehospital.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.example.lenovo.ehospital.DoctorDetailActivity;
import com.example.lenovo.ehospital.Model.DoctorInfo;
import com.example.lenovo.ehospital.R;

import java.util.ArrayList;

import static com.example.lenovo.ehospital.R.id.phone;

/**
 * Created by Lenovo on 9/28/2017.
 */

public class DoctorListAdapter extends ArrayAdapter<DoctorInfo> {
    Context context;
    AQuery aQuery;

    public DoctorListAdapter(Context context, ArrayList<DoctorInfo> list) {
        super(context, 0, list);
        this.context = context;
        AQuery aQuery = new AQuery(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {


        View view = LayoutInflater.from(context).inflate(R.layout.layout_doctor, null);

        TextView name, designation,phone;
        ImageView image;

        name = (TextView) view.findViewById(R.id.name);
        designation = (TextView) view.findViewById(R.id.designation);
        phone       = (TextView) view.findViewById(R.id.phone);

//        image    = (ImageView) view.findViewById(R.id.image);

        final DoctorInfo info = getItem(position);
//        if (info.image != null && info.image.length()){
//            aQuery.id(image).image(info.image, true, true, 300, R.drawable.ic_person_outline_black_24dp);
//        }

        name.setText(info.name);
        designation.setText(info.designation);
        phone.setText(info.phone);
//        doctor_id.setText(info.doctor_id);

        view.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DoctorDetailActivity.class);
                intent.putExtra("id",info.doctorId);
                parent.getContext().startActivity(intent);
            }
        });

        return view;
    }
}
