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
import com.example.lenovo.ehospital.Adapter.HospitalListAdapter;
import com.example.lenovo.ehospital.Model.HospitalInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HospitalActivity extends Fragment {

    ListView listview;
    AQuery aQuery;

//    String fetchUrl = "http://10.0.2.2/ehospital/hospital/select.php";

    String fetchUrl = "http://192.168.1.111/ehospital/hospital/select.php";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.activity_hospital, container, false);

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
                Log.i("response",url +"response:"+ array);

                ArrayList<HospitalInfo> list = new ArrayList<HospitalInfo>();

                for ( int i = 0; i < array.length(); i++){
                    try {
                        JSONObject object = array.getJSONObject(i);
                        HospitalInfo info = new HospitalInfo();

                        info.hospitalId    = object.getString("hospital_id");
                        info.name           = object.getString("name");
                        info.address        = object.getString("address");
                        info.phone          = object.getString("phone");
                        info.generalBedNo   = object.getString("generalBedNo");
                        info.icuBedNo       = object.getString("icuBedNo");
                        info.emergencyBedNo = object.getString("emergencyBedNo");
                        info.longitude      = object.getString("longitude");
                        info.latitude       = object.getString("latitude");
                        info.websiteUrl     = object.getString("websiteUrl");
                        info.description    = object.getString("description");
                        //info.image          = object.getString("image");
                        list.add(info);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                listview.setAdapter(new HospitalListAdapter(getActivity(), list));
            }
        });
    }

}
