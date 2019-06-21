package com.yth520web.student;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends AppCompatActivity {
    /**
     * 辅导员审查表，用于检查和通过学生的申请
     * int applyId;//审查序号，作为主码不重样
     * int insNum;//辅导员工号
     * String applyTableNum;//申请单编号
     * String isInsPass;//辅导员是否通过
     */
    Intent intent;
    ListView listView;
    List<String> keepData = new ArrayList();//保存申请单编号
    public List<ApplyTable> insCheckList = new ArrayList<>();
    List<StudentApply> studentApplies;
    InstructorAdapter instructorAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor);
        //简单点，先用ListView显示
        instructorAdapter = new InstructorAdapter(this,
                R.layout.listview_ins_check,insCheckList);
        listView = (ListView)findViewById(R.id.incCheckListView);
        listView.setAdapter(instructorAdapter);
        listView.setEmptyView(findViewById(R.id.aa));

        intent = getIntent();
        String str = intent.getStringExtra("insId");
        Log.i("Hell",str);
         //设置listView的点击事件

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            //Toast.makeText(Instructor.this,"点击了ListView"+position,Toast.LENGTH_LONG).show();
                //点击后显示具体的申请表，跳转到显示申请表的页面
                Intent show_intent = new Intent(Instructor.this,Show_apply_information.class);
                //将保存的申请单号传到显示的页面
                show_intent.putExtra("applyTableNum",keepData.get(position)+"");
                Log.i("传递的申请单编号是：",keepData.get(position)+"");
                startActivity(show_intent);
            }
        });


        //先根据辅导员工号查询对应的申请单号，再根据申请单号显示对应的学生ID，姓名和专业
        //ApplyTable applyTables= new ApplyTable();
       List<ApplyTable> applyTables = LitePal
                .where("insId=?",""+Integer.parseInt(str))
                .find(ApplyTable.class);
            keepData.clear();
        for (ApplyTable s:applyTables){
            //根据查到的申请单号显示学生的学号，姓名，专业，需要用到StudentApply和StudentInformation
            studentApplies = LitePal
                    .where("applyTableNum=?",s.getApplyTableNum())
                    //.where("isInsPass=?","待审核")
                    .find(StudentApply.class);
            Log.i("根据工号查申请单号",s.getInsId()+""+s.getApplyTableNum());
            keepData.add(s.getApplyTableNum());//保存申请单号到数组
            int stuId = s.getStuId();
            String stuName =s.getStuName();
            String major = s.getMajoy();
            Log.i("Instructor》》》》",stuId+""+stuName+major);
            ApplyTable applyTable = new ApplyTable(stuId,stuName,major);
            insCheckList.add(applyTable);
            instructorAdapter.notifyDataSetChanged();
        }

    }
}

