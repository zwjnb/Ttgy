package com.example.apple.Adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.apple.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

/**
 * Created by aaaaaaaaaaaaaaaaaaaa on 2015/6/20.
 */
public class Main_ViewPager_Adapter extends PagerAdapter {
    private List<ImageView> list_image;
    private DisplayImageOptions options;

    public Main_ViewPager_Adapter(List<ImageView> list_image) {
        this.list_image = list_image;

    }

    @Override
    public int getCount() {
        return list_image.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
//        for(int i=0;i<list_image.size();i++){
//            ImageLoader.getInstance().displayImage(photo, list_image.get(i), options);
//
//        }

        return view == object;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list_image.get(position));
        return list_image.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list_image.get(position));
    }
}
