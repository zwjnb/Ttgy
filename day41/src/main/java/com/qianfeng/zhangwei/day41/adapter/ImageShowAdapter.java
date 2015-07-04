package com.qianfeng.zhangwei.day41.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.qianfeng.zhangwei.day41.R;

import java.util.List;

/**
 * @说 明：
 * @项目名称：1506adc
 * @包 名： com.qianfeng.zhangwei.day39
 * @类 名：ImageShowAdapter
 * @创 建人：zhangwei
 * @创建时间：2015-06-30 10 : 47
 * @版 本：v1.0
 * @修 改人：
 * @修改时间：
 * @修改备注：
 */
public class ImageShowAdapter extends BaseAdapter {

    private List<Bitmap> bitmaps;

    private LayoutInflater inflater;


    public ImageShowAdapter(List<Bitmap> bitmaps, Context context) {
        this.bitmaps = bitmaps;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return bitmaps.size();
    }

    @Override
    public Object getItem(int position) {
        return bitmaps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_img_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.img.setImageBitmap(bitmaps.get(position));
        return convertView;
    }

    public static class ViewHolder {
        public ImageView img;
        public CheckBox cb;
        public ViewHolder(View convertView) {
            this.img = (ImageView) convertView.findViewById(R.id.item_img);
            this.cb = (CheckBox) convertView.findViewById(R.id.item_checkbox);
        }
    }


}
