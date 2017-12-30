package com.example.lenovo.ehospital;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.lenovo.ehospital.Adapter.DoctorListAdapter;
import com.example.lenovo.ehospital.Model.DoctorInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DoctorDetailActivity extends FragmentActivity {

    String id;
    Context context;

    TextView name, designation, description, phone,nmc_no;
    ImageView image;
    AQuery aQuery;

    //String fetchUrl = "http://10.0.2.2/ehospital/doctor/select.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);
        aQuery = new AQuery(getApplicationContext());
        id = getIntent().getStringExtra("id");

        DoctorInfo info = new DoctorInfo();
        String fetchUrl = "http://192.168.1.111/ehospital/doctor/doctordetail.php?id="+id;
        image   = (ImageView) findViewById(R.id.image);
        name = (TextView) findViewById(R.id.name);
        designation  = (TextView) findViewById(R.id.designation);
        description    = (TextView) findViewById(R.id.description);
        phone    = (TextView) findViewById(R.id.phone);
        nmc_no    = (TextView) findViewById(R.id.nmc_no);
        info = fetchData(fetchUrl);

    }

    public DoctorInfo fetchData(String fetchUrl){
        final DoctorInfo info = new DoctorInfo();
        aQuery.ajax(fetchUrl, JSONArray.class, new AjaxCallback<JSONArray>(){
            @Override
            public void callback(String url, JSONArray array, AjaxStatus status) {
                super.callback(url, array, status);
                Log.i("response", url +"response:"+ array);

                ArrayList<DoctorInfo> list = new ArrayList<DoctorInfo>();

                for (int i = 0; i < array.length(); i++){
                    try {
                        JSONObject object = array.getJSONObject(i);

                        info.doctorId = object.getString("doctor_id");
                        info.name    = object.getString("name");
                        info.designation = object.getString("designation");
                        info.description = object.getString("description");
                        info.phone = object.getString("phone");
                        info.nmc_no = object.getString("nmc_no");
                        info.image = object.optString("image");
                        name.setText(info.name);
                        designation.setText(info.designation);
                        phone.setText(info.phone);
                        description.setText(info.description);
                        nmc_no.setText(info.nmc_no);
                        //list.add(info);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        return info;
    }
}
