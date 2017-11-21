package com.example.lenovo.ehospital;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.androidquery.AQuery;

public class DonateBloodActivity extends Fragment {

    EditText name, phone, address, lastDonatedDate;
    Button register, donorList;
//    TextInputLayout nameWrapper, phoneWrapper, addressWrapper, lastDonatedDateWrapper;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.activity_donate_blood, container, false);

        donorList = (Button) V.findViewById(R.id.donorList);
        register = (Button) V.findViewById(R.id.register);

        donorList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return V;

    }

//    public void setHint(){
//        nameWrapper.setHint("Name");
//        phoneWrapper.setHint("Phone");
//    }
}
