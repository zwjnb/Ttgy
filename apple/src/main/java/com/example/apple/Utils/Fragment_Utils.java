package com.example.apple.Utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import java.util.List;

/**
 * Created by Administrator on 15-6-22.
 */
public class Fragment_Utils implements RadioGroup.OnCheckedChangeListener {
    private int Fid;
    private List<Fragment> list_ft;
    private RadioGroup RG;
    private FragmentManager supportFragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Context context;
    private int currentTab; // 当前Tab页面索引

    public Fragment_Utils(Context context, int Fid, final List<Fragment> list_ft, RadioGroup RG, FragmentManager supportFragmentManager) {
        this.Fid = Fid;
        this.list_ft = list_ft;
        this.RG = RG;
        this.context = context;
        this.supportFragmentManager = supportFragmentManager;
        fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(Fid, list_ft.get(0)).commit();
        RG.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < list_ft.size(); i++) {
            FragmentTransaction ft = supportFragmentManager.beginTransaction();
            Fragment fragment = list_ft.get(i);
            if (checkedId == RG.getChildAt(i).getId()) {

                fragment.onStop();
                if (fragment.isAdded()) {
                    fragment.onStart();

                } else {
                    supportFragmentManager.beginTransaction().add(Fid, list_ft.get(i)).commit();
                }
                ft.show(fragment).commit();

            } else {
                ft.hide(fragment).commit();
            }
        }
    }

}