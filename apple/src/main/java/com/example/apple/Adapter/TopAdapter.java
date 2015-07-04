package com.example.apple.Adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.apple.R;
import com.example.apple.bean.Top_Banner;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;


/**
 * Created by Administrator on 15-6-25.
 */
public class TopAdapter extends AppBaseAdapter<Top_Banner> {

    private DisplayImageOptions options;

    public TopAdapter(Context context, List<Top_Banner> list) {
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
            convertView = inflater.inflate(R.layout.item_top_fragment, parent, false);
            Vh = new ViewHolder();
            Vh.image = (ImageView) convertView.findViewById(R.id.top_image1);
            //Vh.getView(convertView);
            convertView.setTag(Vh);
        } else {
            Vh = (ViewHolder) convertView.getTag();
        }
        String photo = list.get(position).getPhoto();
        ImageLoader.getInstance().displayImage(photo, Vh.image, options);
        return convertView;
    }

    public class ViewHolder {
        private ImageView image;

//        public void getView(View view) {
//
//        }
    }
}
