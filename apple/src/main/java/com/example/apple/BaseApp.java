package com.example.apple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by aaaaaaaaaaaaaaaaaaaa on 2015/6/20.
 */
public class BaseApp extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base);
        AnimationSet animationSet = new AnimationSet(true);
        ImageView img = (ImageView) findViewById(R.id.base_image);
        TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0f, 0f);
        translateAnimation.setDuration(3 * 1000);
        animationSet.addAnimation(translateAnimation);
        img.setAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(BaseApp.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

}
