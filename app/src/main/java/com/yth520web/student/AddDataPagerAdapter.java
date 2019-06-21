package com.yth520web.student;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AddDataPagerAdapter extends FragmentPagerAdapter {

    String title[] = new String[]{"添加学生数据","添加辅导员数据"};
    public AddDataPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return new AddData_Stu();
        }else{
            return new AddData_Ins();
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
