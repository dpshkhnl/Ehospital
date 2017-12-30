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
import com.example.lenovo.ehospital.Adapter.BloodDonorListAdapter;
import com.example.lenovo.ehospital.Model.BloodDonorInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BloodDonorActivity extends Fragment {

    ListView listview;
    AQuery aQuery;

    //String fetchUrl = "http://10.0.2.2/ehospital/bloodDonor/select.php";
    String fetchUrl = "http://192.168.1.111/ehospital/bloodDonor/select.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.activity_blood_donor, container, false);

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
                Log.i("response", url + "response:" + array);

                ArrayList<BloodDonorInfo> list = new ArrayList<BloodDonorInfo>();

                for ( int i = 0; i < array.length(); i++){
                    try {
                        JSONObject object = array.getJSONObject(i);
                        BloodDonorInfo info = new BloodDonorInfo();

                        info.bloodDonorId = object.getString("bloodDonor_id");
                        info.name          = object.getString("name");
                        info.phone         = object.getString("phone");
                        info.address       = object.getString("address");
                        info.bloodGroup    = object.getString("bloodGroup");
                        info.lastDonatedDate = object.getString("lastDonatedDate");

                        list.add(info);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                listview.setAdapter(new BloodDonorListAdapter(getActivity(), list));
            }
        });
    }
}
