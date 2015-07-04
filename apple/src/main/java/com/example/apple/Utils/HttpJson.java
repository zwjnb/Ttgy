package com.example.apple.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.apple.bean.Rotation;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/6/21 0021.
 */
public class HttpJson {
    public static List<Rotation> getJSON(String url) {
        try {
            JSONObject jsonObject = new JSONObject(url);
            JSONArray rotation = jsonObject.optJSONArray("rotation");
            List<Rotation> list_rt = new ArrayList<>();
            // List<Rotation> rotations = JSON.parseArray(rotation.toString(), Rotation.class);
            for (int i = 0; i < rotation.length(); i++) {
                JSONObject jsonObject1 = rotation.optJSONObject(i);
                Rotation RT = new Rotation();
                String s = jsonObject1.optString("photo");
                RT.setPhoto(s);
                list_rt.add(RT);
            }

            return list_rt;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
