package com.example.apple.Utils;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��? ?����
 * �� �� �ˣ�zhangwei
 * ��? ? �ڣ�2015-06-14 15:16
 * �� �� �ˣ�
 * ��? ?�ڣ�
 * �� �� �ţ�v1.0
 */
public class HttpUtils {

    public static String post(String url, Map<String, String> map) throws UnsupportedEncodingException {
        String s = null;
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        ArrayList<NameValuePair> params = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            NameValuePair nameValuePair = new BasicNameValuePair(entry.getKey(), entry.getValue());
            params.add(nameValuePair);
        }
        UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(params, "UTF-8");
        post.setEntity(encodedFormEntity);
        try {
            HttpResponse response = httpClient.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                s = EntityUtils.toString(entity);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }


}
