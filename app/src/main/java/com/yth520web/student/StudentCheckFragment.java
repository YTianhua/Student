package com.yth520web.student;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentCheckFragment extends Fragment {
    /*(1）申请单编号
    （2）辅导员是否通过
    （3）教务处是否通过
    （4）安排的教室
    （5）安排的时间段-*/
    ListView listView;
    String mLog;
    int count=-10;
    SwipeRefreshLayout swipeRefreshLayout;
    ApplyProcessAdapter applyProcessAdapter;
    public List<ApplyProcess> stuCheckList = new ArrayList<>();
    public StudentCheckFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_student_check, container, false);
        initData();//初始化数据
        SharedPreferences preferences = getActivity().getSharedPreferences("文件名", Context.MODE_PRIVATE);
        mLog = preferences.getString("log", "41711056");
        initData();//初始化数据
        Log.i("传值》》",mLog);
         applyProcessAdapter = new ApplyProcessAdapter(getActivity(),
                R.layout.listview_stu_check,stuCheckList);
        listView = (ListView)view.findViewById(R.id.studentCheckListView);
        listView.setAdapter(applyProcessAdapter);
        listView.setEmptyView(view.findViewById(R.id.aa));
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
                applyProcessAdapter.notifyDataSetChanged();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }).start();
            }
        });
        return view;

    }
    public void initData() {
        stuCheckList.clear();
        Log.i("执行initData",1+"");
        //List<ApplyProcess> aa = LitePal.where("stuId=?",Integer.parseInt(mLog)+"").find(ApplyProcess.class);
        List<ApplyProcess> aa = LitePal.findAll(ApplyProcess.class);
            for (ApplyProcess s : aa) {
                if ((s.getStuId()+"").equals(mLog)) {
                    Log.i("进度表匹配到学生的学号信息", "》》》》");
                    Log.i("ApplyProcess表的长度", aa.size()+"》》》》");
                    ApplyProcess applyProcess = new ApplyProcess(s.getApplyTableNum(), s.getIsInsPass(),
                            s.getIsOfficePass(), s.getArrangeClass(), s.getArrangeHour());
                    Log.i("检验applyProcess", s.getApplyTableNum() + "" + s.getIsInsPass() + "" +
                            s.getIsOfficePass() + "" + s.getArrangeClass() + "" + s.getArrangeHour());
                    stuCheckList.add(applyProcess);
                    //isHasMessage =true;
                }
            }
    }
}
