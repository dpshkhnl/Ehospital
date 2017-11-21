package com.example.lenovo.ehospital.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.example.lenovo.ehospital.Model.BloodDonorInfo;
import com.example.lenovo.ehospital.R;

import java.util.ArrayList;

/**
 * Created by Lenovo on 9/27/2017.
 */

public class BloodDonorListAdapter extends ArrayAdapter<BloodDonorInfo> {
    Context context;
    AQuery aQuery;

    public BloodDonorListAdapter(Context context, ArrayList<BloodDonorInfo> list) {
        super(context, 0, list);
        this.context = context;
        AQuery aQuery = new AQuery(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_blooddonor, null);

        TextView name, phone, address;

        name = (TextView) view.findViewById(R.id.name);
        phone = (TextView) view.findViewById(R.id.phone);
        address = (TextView) view.findViewById(R.id.address);

        BloodDonorInfo info = getItem(position);

        name.setText(info.name);
        phone.setText(info.phone);
        address.setText(info.address);

        return view;
    }
}
