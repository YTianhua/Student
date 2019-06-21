package com.yth520web.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class Show_apply_information extends AppCompatActivity {
    String applyTableNum;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        /*int stuId;//新增
        String stuName;//新增
        String majoy;//新增
        String applyTableNum;//申请单编号
        int insId;//辅导员工号
        String applyDay;//申请日期
        String applyHour;//申请时长
        String applyReason;//申请原因
        String peopleNum;//申请的总人数-->*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_apply_information);
        //显示具体的申请细节
        Intent intent=getIntent();
        applyTableNum = intent.getStringExtra("applyTableNum");
        Log.i("传递过来的申请单编号是：",applyTableNum);
        TextView show_stuId = (TextView)findViewById(R.id.show_stuId);
        TextView show_stuName = (TextView)findViewById(R.id.show_stuName);
        TextView show_majoy = (TextView)findViewById(R.id.show_majoy);
        TextView show_applyDay = (TextView)findViewById(R.id.show_applyDay);
        TextView show_applyHour = (TextView)findViewById(R.id.show_applyHour);
        TextView applyReason = (TextView)findViewById(R.id.show_applyReason);
        TextView show_peopleNum = (TextView)findViewById(R.id.show_peopleNum);
        //开启查询
        List<ApplyTable> applyTables = LitePal.where("applyTableNum=?",applyTableNum)
                .find(ApplyTable.class);
        for (ApplyTable s:applyTables){
            show_stuId.setText(s.getStuId()+"");
            show_stuName.setText(s.getStuName());
            show_majoy.setText(s.getMajoy());
            show_applyDay.setText(s.getApplyDay()+"");
            show_applyHour.setText(s.getApplyHour()+"");
            applyReason.setText(s.getApplyReason()+"");
            show_peopleNum.setText(s.getPeopleNum()+"");
        }
        //设置Yes和No按钮的点击事件
        Button yes = (Button)findViewById(R.id.Yes);
        Button no = (Button)findViewById(R.id.No);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //yes的时候，使学生查询进度表的isInsPass值为"4"
                    //Toast.makeText(Show_apply_information.this, "点击yes" + applyTableNum, Toast.LENGTH_SHORT).show();
                    //ApplyProcess applyProcess = new ApplyProcess(applyTableNum, "是", "否", null, null);
                    ApplyProcess applyProcess = new ApplyProcess();
                    applyProcess.setIsInsPass("通过");
                    applyProcess.updateAll("applyTableNum = ?", applyTableNum);
                    Log.i("尝试更新数据：", applyTableNum);
                    Toast.makeText(Show_apply_information.this, "成功通过" , Toast.LENGTH_SHORT).show();
                    ApplyTable applyTable = new ApplyTable();
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                    Log.i("更改数据出错",e+"");
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplyProcess applyProcess = new ApplyProcess();
                applyProcess.setIsInsPass("拒绝");
                applyProcess.updateAll("applyTableNum=?",applyTableNum);
                Toast.makeText(Show_apply_information.this, "审核不通过" , Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}
