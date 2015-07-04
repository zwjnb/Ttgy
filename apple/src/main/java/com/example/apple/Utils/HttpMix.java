package com.example.apple.Utils;

import com.example.apple.bean.Mix_Banner;
import com.example.apple.bean.Rotation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/6/21 0021.
 */
public class HttpMix {
    public static List<Mix_Banner> getJSON(String url) {
        try {
            JSONObject jsonObject = new JSONObject(url);
            JSONArray rotation = jsonObject.optJSONArray("mix_product_banner");
            List<Mix_Banner> list_rt = new ArrayList<>();
            // List<Rotation> rotations = JSON.parseArray(rotation.toString(), Rotation.class);
            for (int i = 0; i < rotation.length(); i++) {
                JSONObject jsonObject1 = rotation.optJSONObject(i);
                Mix_Banner RT = new Mix_Banner();
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
