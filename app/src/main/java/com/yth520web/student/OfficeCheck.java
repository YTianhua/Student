package com.yth520web.student;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class OfficeCheck extends AppCompatActivity {

    String applyTableNum;//申请单编号
    String isOfficePass;//教务处是否通过
    OfficeCheckAdapter officeCheckAdapter;

    List<OfficeCheckBean> officeCheckBeans = new ArrayList<>();
    List keepData = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.office);
        officeCheckAdapter = new OfficeCheckAdapter(this,
                R.layout.listview_office_check,officeCheckBeans);
        ListView listView = (ListView)findViewById(R.id.office_check_listview);
        listView.setAdapter(officeCheckAdapter);
        listView.setEmptyView(findViewById(R.id.fragment_order_new_empty_view));

        //定义一个浮动按钮，用于添加往数据库中添加数据
        //点击悬浮按钮时候，跳转到添加数据的页面
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到添加数据的页面
                LitePal.getDatabase();//创建数据库
                Intent intent = new Intent(OfficeCheck.this,AddData.class);
                startActivity(intent);
            }
        });
        //添加数据
        List<ApplyProcess> applyProcesses = LitePal.where("isInsPass=?","通过").find(ApplyProcess.class);
        for (ApplyProcess applyProcess:applyProcesses) {
            List<ApplyTable> applyTables = LitePal.where("applyTableNum=?",applyProcess.getApplyTableNum()).find(ApplyTable.class);
            for (ApplyTable a : applyTables) {
                keepData.add(a.getApplyTableNum());
                OfficeCheckBean officeCheckBean = new OfficeCheckBean(a.getApplyTableNum());
                officeCheckBeans.add(officeCheckBean);
                officeCheckAdapter.notifyDataSetChanged();
            }
        }
        if (officeCheckBeans.isEmpty()){
            final AlertDialog.Builder normalDialog =
                    new AlertDialog.Builder(OfficeCheck.this);
            normalDialog.setIcon(R.drawable.swufe);
            normalDialog.setTitle("管理员页面");
            normalDialog.setMessage("目前没有学生进行申请");
            normalDialog.setPositiveButton("确定",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //...To-do
                        }
                    });
            normalDialog.setNegativeButton("关闭",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //...To-do
                        }
                    });
            // 显示
            normalDialog.show();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent show_intent = new Intent(OfficeCheck.this,AnPai.class);
                //将保存的申请单号传到显示的页面
                show_intent.putExtra("applyTableNum",keepData.get(position)+"");
                Log.i("传递的申请单编号是：",keepData.get(position)+"");
                startActivity(show_intent);
            }
        });
    }
}