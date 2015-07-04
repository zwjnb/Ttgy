package com.example.apple.Utils;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aaaaaaaaaaaaaaaaaaaa on 2015/6/20.
 */
public class Final_utils {

    public static Map<String, String> initView(Map<String, String> map) {
        map = new HashMap<>();
        map.put("channel", "wandoujia");
        map.put("connect_id", "52181c52e322c5c7dded36406492101f");
        map.put("device_id", "2fa4e592198ebcfe75132a0d91019021");
        map.put("platform", "ANDROID");
        map.put("region_id", "143949");
        map.put("service", "marketing.banner");
        map.put("sign", "58b4092bbf27045569820c1b973fef44");
        map.put("source", "app");
        map.put("timestamp", "1434787641");
        map.put("version", "2.1.1");

        return map;
    }
}
