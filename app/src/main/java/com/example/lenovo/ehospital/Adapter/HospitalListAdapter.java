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
import com.example.lenovo.ehospital.HospitalDetailActivity;
import com.example.lenovo.ehospital.Model.HospitalInfo;
import com.example.lenovo.ehospital.R;

import java.util.ArrayList;

/**
 * Created by Lenovo on 9/28/2017.
 */

public class HospitalListAdapter  extends ArrayAdapter<HospitalInfo>{
    Context context;
    AQuery aQuery;

    public HospitalListAdapter(Context context, ArrayList<HospitalInfo> list) {
        super(context,0, list);
        this.context = context;
        AQuery aQuery = new AQuery(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_hospital, null);

        TextView name, address, phone;
        ImageView image;

        name    = (TextView) view.findViewById(R.id.name);
        address = (TextView) view.findViewById(R.id.address);
        phone   = (TextView) view.findViewById(R.id.phone);
//      image   = (ImageView) view.findViewById(R.id.image);

        final HospitalInfo info = getItem(position);

//          if (info.image != null && info.image.length()){
//            aQuery.id(image).image(info.image, true, true, 300, R.drawable.ic_person_outline_black_24dp);
//        }

        name.setText(info.name);
        address.setText(info.address);
        phone.setText(info.phone);

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HospitalDetailActivity.class);
                intent.putExtra("id", info.hospitalId);
                parent.getContext().startActivity(intent);
            }
        });

        return view;
    }
}
