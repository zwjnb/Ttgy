package com.example.apple.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.apple.Adapter.TopAdapter;
import com.example.apple.R;
import com.example.apple.Utils.Final_utils;
import com.example.apple.Utils.HttpTop;
import com.example.apple.Utils.URL_connt;
import com.example.apple.bean.Top_Banner;
import com.example.apple.sync.View_sync;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 15-6-25.
 */
public class Top_fragment extends Fragment {
    private Map<String, String> map;
    private TopAdapter topAdapter;
    private ListView list;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragment, null);
        list = (ListView) view.findViewById(R.id.top_list);
        initView(inflater);
        return view;
    }

    private void initView(LayoutInflater inflater) {
        Map<String, String> stringStringMap = Final_utils.initView(map);
        new View_sync(stringStringMap, new View_sync.ViewHolder() {
            @Override
            public void send(String tList) {
                List<Top_Banner> json = HttpTop.getJSON(tList);
                topAdapter = new TopAdapter(getActivity(), json);
                list.setAdapter(topAdapter);
            }
        }).execute(URL_connt.URL_api);
    }


}
