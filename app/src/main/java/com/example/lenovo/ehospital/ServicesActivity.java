package com.example.lenovo.ehospital;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.lenovo.ehospital.Adapter.ServicesAdapter;
import com.example.lenovo.ehospital.Model.ServicesInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ServicesActivity extends Fragment {

    GridView gridview;
    AQuery aQuery;

        String fetchUrl = "http://192.168.1.111/ehospital/services/select.php";
    //String fetchUrl = "http://10.0.2.2/ehospital/services/select.php";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View V = inflater.inflate(R.layout.activity_services, container, false);

        gridview = (GridView) V.findViewById(R.id.gridview);
        aQuery = new AQuery(getActivity());
        fetchData();
        return V;

    }

    public void fetchData(){
        aQuery.ajax(fetchUrl, JSONArray.class,new AjaxCallback<JSONArray>(){
            @Override
            public void callback(String url, JSONArray array, AjaxStatus status) {
                super.callback(url, array, status);
                Log.i("response",url +"response:"+ array);

                ArrayList<ServicesInfo> list = new ArrayList<ServicesInfo>();

                for ( int i = 0; i < array.length(); i++){
                    try {
                        JSONObject object = array.getJSONObject(i);

                        ServicesInfo info = new ServicesInfo();

                        info.servicesId = object.getString("services_id");
                        info.name        = object.getString("name");
                        info.image       = object.optString("image");
                        list.add(info);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                gridview.setAdapter(new ServicesAdapter(getActivity(), list));
            }
        });
    }

}
