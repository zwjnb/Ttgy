package com.example.apple.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.apple.Adapter.MixAdapter;
import com.example.apple.Adapter.MyListAdapter;
import com.example.apple.R;
import com.example.apple.Utils.Final_utils;
import com.example.apple.Utils.HttpBanner;
import com.example.apple.Utils.HttpMix;
import com.example.apple.Utils.URL_connt;
import com.example.apple.bean.Banner;
import com.example.apple.bean.Mix_Banner;
import com.example.apple.sync.View_sync;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 15-6-25.
 */
public class Mix_fragment extends Fragment {
    private MixAdapter MLA;
    private Map<String, String> map;
    private List<ImageView> list_image = new ArrayList<>();
    public List<Banner> list;
    private DisplayImageOptions options;
    private List<Mix_Banner> json;
    private ListView list_fragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.head_list_fragment, null);
        list_fragment = (ListView) inflate.findViewById(R.id.fragment_list);
        Log.i("info", "======6663==========");
        Map<String, String> stringStringMap = Final_utils.initView(map);

        new View_sync(stringStringMap, new View_sync.ViewHolder() {
            @Override
            public void send(String tList) {

                json = HttpMix.getJSON(tList);
                Log.i("info", "======7777==========" + json.size());
                MLA = new MixAdapter(getActivity(), json);

                list_fragment.setAdapter(MLA);
            }
        }).execute(URL_connt.URL_api);

        return inflate;
    }
}
