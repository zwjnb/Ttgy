package com.example.apple.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 15-6-25.
 */
public abstract class AppBaseAdapter<T> extends BaseAdapter {
    public Context context;
    public List<T> list;
    public LayoutInflater inflater;

    public AppBaseAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list != null && !list.isEmpty() ? list.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        return getItemView(position, view, viewGroup);
    }

    public abstract View getItemView(int position, View view, ViewGroup viewGroup);
}

