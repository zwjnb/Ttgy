package com.example.apple.sync;

import android.os.AsyncTask;
import android.util.Log;

import com.example.apple.Utils.HttpUtils;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Created by aaaaaaaaaaaaaaaaaaaa on 2015/6/20.
 */
public class View_sync extends AsyncTask<String, Void, String> {
    private ViewHolder VH;
    private Map<String, String> map;

    public View_sync(Map<String, String> map, ViewHolder VH) {
        this.map = map;
        this.VH = VH;

    }

    @Override
    protected String doInBackground(String... params) {
        String post = null;
        try {

            post = HttpUtils.post(params[0], map);

            Log.i("info", "============" + post.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    protected void onPostExecute(String tList) {
        super.onPostExecute(tList);

        VH.send(tList);
    }

    public interface ViewHolder {
        public void send(String tList);
    }
}
