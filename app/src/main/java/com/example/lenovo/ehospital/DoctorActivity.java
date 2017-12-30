package com.example.lenovo.ehospital;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.lenovo.ehospital.Adapter.DoctorListAdapter;
import com.example.lenovo.ehospital.Model.DoctorInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DoctorActivity extends Fragment {
    ListView listview;
    AQuery aQuery;

    //String fetchUrl = "http://10.0.2.2/ehospital/doctor/select.php";
    String fetchUrl = "http://192.168.1.111/ehospital/doctor/select.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.activity_doctor, container, false);

        listview = (ListView) V.findViewById(R.id.listview);
        aQuery = new AQuery(getActivity());
        fetchData();
        return V;

    }


    public void fetchData(){
        aQuery.ajax(fetchUrl, JSONArray.class, new AjaxCallback<JSONArray>(){
            @Override
            public void callback(String url, JSONArray array, AjaxStatus status) {
                super.callback(url, array, status);
                Log.i("response", url +"response:"+ array);

                ArrayList<DoctorInfo> list = new ArrayList<DoctorInfo>();

                for (int i = 0; i < array.length(); i++){
                    try {
                        JSONObject object = array.getJSONObject(i);
                        DoctorInfo info = new DoctorInfo();

                        info.doctorId = object.getString("doctor_id");
                        info.name    = object.getString("name");
                        info.designation = object.getString("designation");
                        info.description = object.getString("description");
                        info.phone = object.getString("phone");
                        info.nmc_no = object.getString("nmc_no");
                        info.image = object.optString("image");
                        list.add(info);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listview.setAdapter(new DoctorListAdapter(getActivity(), list));
            }
        });
    }
}
