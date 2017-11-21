package com.example.lenovo.ehospital;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.ehospital.Model.DoctorInfo;

public class DoctorDetailActivity extends FragmentActivity {

    String id;
    Context context;

    TextView name, designation, description, phone,nmc_no;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        id = getIntent().getStringExtra("id");
        DoctorInfo info = new DoctorInfo();

        image   = (ImageView) findViewById(R.id.image);
        name = (TextView) findViewById(R.id.name);
        designation  = (TextView) findViewById(R.id.designation);
        description    = (TextView) findViewById(R.id.description);
        phone    = (TextView) findViewById(R.id.phone);
        nmc_no    = (TextView) findViewById(R.id.nmc_no);

        name.setText(info.name);
        designation.setText(info.designation);
        phone.setText(info.phone);
        description.setText(info.description);
        nmc_no.setText(info.nmc_no);


    }
}
