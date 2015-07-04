package com.example.apple.Adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.apple.R;
import com.example.apple.bean.Mix_Banner;
import com.example.apple.bean.Top_Banner;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;


/**
 * Created by Administrator on 15-6-25.
 */
public class MixAdapter extends AppBaseAdapter<Mix_Banner> {

    private DisplayImageOptions options;

    public MixAdapter(Context context, List<Mix_Banner> list) {
        super(context, list);
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ss) // ����ͼƬ�����ڼ���ʾ��ͼƬ
                .showImageForEmptyUri(R.drawable.ss) // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
                .showImageOnFail(R.drawable.ss) // ����ͼƬ���ػ�������з��������ʾ��ͼƬ
                .cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
                .cacheOnDisk(true) // �������ص�ͼƬ�Ƿ񻺴���SD����
                .build(); //
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder Vh = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.mix_fargment, parent, false);
            Vh = new ViewHolder();


            Vh.mix_image1 = (ImageView) convertView.findViewById(R.id.mix_image1);
            Vh.mix_image2 = (ImageView) convertView.findViewById(R.id.mix_image2);
            Vh.mix_image3 = (ImageView) convertView.findViewById(R.id.mix_image3);
            Vh.mix_image1_below = (ImageView) convertView.findViewById(R.id.mix_image1_beloew);
            Vh.mix_image2_below = (ImageView) convertView.findViewById(R.id.mix_image2_beloew);
            Vh.mix_image3_below = (ImageView) convertView.findViewById(R.id.mix_image3_beloew);
            //Vh.getView(convertView);
            convertView.setTag(Vh);
        } else {
            Vh = (ViewHolder) convertView.getTag();
        }
        for (int i = 0; i < list.size(); i++) {
            String photo = list.get(i).getPhoto();
            if (i == 0) {
                ImageLoader.getInstance().displayImage(photo, Vh.mix_image1, options);
            } else if (i == 1) {
                ImageLoader.getInstance().displayImage(photo, Vh.mix_image2, options);
            } else if (i == 2) {
                ImageLoader.getInstance().displayImage(photo, Vh.mix_image3, options);
            } else
            if (i == 3) {
                ImageLoader.getInstance().displayImage(photo, Vh.mix_image1_below, options);
            } else if (i == 4) {
                ImageLoader.getInstance().displayImage(photo, Vh.mix_image2_below, options);
            } else if (i == 5) {
                ImageLoader.getInstance().displayImage(photo, Vh.mix_image3_below, options);
            }
        }


        return convertView;
    }

    public class ViewHolder {
        private ImageView mix_image1, mix_image2, mix_image3, mix_image1_below, mix_image2_below, mix_image3_below;

//        public void getView(View view) {
//
//        }
    }
}
