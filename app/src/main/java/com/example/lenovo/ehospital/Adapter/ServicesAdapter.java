package com.example.lenovo.ehospital.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.example.lenovo.ehospital.Model.ServicesInfo;
import com.example.lenovo.ehospital.R;

import java.util.ArrayList;

/**
 * Created by Lenovo on 9/29/2017.
 */

public class ServicesAdapter extends ArrayAdapter<ServicesInfo> {
    Context context;
    AQuery aQuery;

    public ServicesAdapter(Context context, ArrayList<ServicesInfo> list) {
        super(context, 0, list);
        this.context = context;
        AQuery aQuery = new AQuery(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_services, null);
        TextView name;
        ImageView image;

        name = (TextView) view.findViewById(R.id.name);
        image    = (ImageView) view.findViewById(R.id.image);

        ServicesInfo info = getItem(position);
//        aQuery.id(image).image(info.image, true, true, 300, R.drawable.ic_person_outline_black_24dp);

        name.setText(info.name);

        return view;
    }
}
