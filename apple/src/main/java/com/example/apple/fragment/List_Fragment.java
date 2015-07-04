package com.example.apple.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.apple.Adapter.Main_ViewPager_Adapter;
import com.example.apple.Adapter.MyListAdapter;
import com.example.apple.R;
import com.example.apple.Utils.Final_utils;
import com.example.apple.Utils.HttpBanner;
import com.example.apple.Utils.HttpJson;
import com.example.apple.Utils.HttpUtils;
import com.example.apple.Utils.URL_connt;
import com.example.apple.bean.Banner;
import com.example.apple.bean.Rotation;
import com.example.apple.sync.View_sync;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 15-6-22.
 */
public class List_Fragment extends Fragment {
    private MyListAdapter MLA;
    private Map<String, String> map;
    private List<ImageView> list_image = new ArrayList<>();
    public List<Banner> list;
    private DisplayImageOptions options;
    private List<Banner> json;
    private ListView list_fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.head_list_fragment, null);
        list_fragment = (ListView) inflate.findViewById(R.id.fragment_list);
        Log.i("info", "======6663==========");
        Map<String, String> stringStringMap = Final_utils.initView(map);

        new View_sync(stringStringMap, new View_sync.ViewHolder() {
            @Override
            public void send(String tList) {

                json = HttpBanner.getJSON(tList);
                Log.i("info", "======7777==========" + json.size());
                MLA = new MyListAdapter(getActivity(), json);

                list_fragment.setAdapter(MLA);
            }
        }).execute(URL_connt.URL_api);

        return inflate;
    }
}
