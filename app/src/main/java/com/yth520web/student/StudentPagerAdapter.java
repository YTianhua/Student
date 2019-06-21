package com.yth520web.student;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class StudentPagerAdapter extends FragmentPagerAdapter {

    String title[] = new String[]{"填写申请表","查看申请进度"};
    public StudentPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return new StudentApplyFragment();
        }else{
            return new StudentCheckFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
    //获得getPageTitle
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
