package com.example.lenovo.ehospital.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.example.lenovo.ehospital.Model.PharmacyInfo;
import com.example.lenovo.ehospital.R;

import java.util.ArrayList;

/**
 * Created by Lenovo on 9/29/2017.
 */

public class PharmacyListAdapter extends ArrayAdapter<PharmacyInfo> {


    Context context;
    AQuery aQuery;

    public PharmacyListAdapter(Context context, ArrayList<PharmacyInfo> list) {
        super(context, 0, list);
        this.context = context;
        AQuery aQuery = new AQuery(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_pharmacy, null);

        TextView name, address, phone;

        name = (TextView) view.findViewById(R.id.name);
        address = (TextView) view.findViewById(R.id.address);
        phone = (TextView) view.findViewById(R.id.phone);

        PharmacyInfo info = getItem(position);

        name.setText(info.name);
        address.setText(info.address);
        phone.setText(info.phone);

        return view;
    }
}
