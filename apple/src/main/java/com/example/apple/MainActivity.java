package com.example.apple;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.example.apple.Adapter.Main_ViewPager_Adapter;
import com.example.apple.Utils.Final_utils;
import com.example.apple.Utils.Fragment_Utils;
import com.example.apple.Utils.HttpJson;
import com.example.apple.Utils.URL_connt;
import com.example.apple.bean.Rotation;
import com.example.apple.fragment.Cart;
import com.example.apple.fragment.Category;
import com.example.apple.fragment.Guoshi;
import com.example.apple.fragment.Head_fragment;
import com.example.apple.fragment.Smile;
import com.example.apple.sync.View_sync;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    private Map<String, String> map;
    private List<ImageView> list_image = new ArrayList<>();
    private Main_ViewPager_Adapter MPA;
    private DisplayImageOptions options;
    private ViewPager vp;

    //    channel	wandoujia
//    connect_id	52181c52e322c5c7dded36406492101f
//    device_id	2fa4e592198ebcfe75132a0d91019021
//    platform	ANDROID
//    region_id	143949
//    service	marketing.banner
//    sign	58b4092bbf27045569820c1b973fef44
//    source	app
//    timestamp	1434787641
//    version	2.1.1

    private FrameLayout FL;
    private RadioGroup RG;
    private Cart cart;
    private Category category;
    private Guoshi guoshi;
    private Head_fragment head_fragment;
    private Smile smile;
    private List<Fragment> list_ft = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FL = (FrameLayout) findViewById(R.id.FL);
        RG = (RadioGroup) findViewById(R.id.main_radio1);
        cart = new Cart();
        category = new Category();
        guoshi = new Guoshi();
        head_fragment = new Head_fragment();
        smile = new Smile();
        list_ft.add(head_fragment);
        list_ft.add(category);
        list_ft.add(smile);
        list_ft.add(cart);

        list_ft.add(guoshi);


        initView();


    }

    private void initView() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        new Fragment_Utils(this, R.id.FL, list_ft, RG, supportFragmentManager);

    }

}
