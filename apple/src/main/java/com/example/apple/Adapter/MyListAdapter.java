package com.example.apple.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.apple.R;
import com.example.apple.bean.Banner;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 15-6-22.
 */
public class MyListAdapter extends BaseAdapter {
    public List<Banner> list;
    public Context context;
    private LayoutInflater inflater;
    private DisplayImageOptions options;

    public MyListAdapter(Context context, List<Banner> list) {

        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ss) // ����ͼƬ�����ڼ���ʾ��ͼƬ
                .showImageForEmptyUri(R.drawable.ss) // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
                .showImageOnFail(R.drawable.ss) // ����ͼƬ���ػ�������з��������ʾ��ͼƬ
                .cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
                .cacheOnDisk(true) // �������ص�ͼƬ�Ƿ񻺴���SD����
                .build(); // �������

    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder VH = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_image, null);
            VH = new ViewHolder();
            VH.listimage = (ImageView) convertView.findViewById(R.id.listimage);
        }
        Banner banner = list.get(position);

        ImageLoader.getInstance().displayImage(banner.getPhoto(), VH.listimage, options);
        return convertView;
    }

    public class ViewHolder {
        public ImageView listimage;
    }
}
