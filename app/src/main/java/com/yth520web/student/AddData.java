package com.yth520web.student;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class AddData extends AppCompatActivity {

    int currIndex=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data);

        ViewPager viewPager = (ViewPager)findViewById(R.id.add_data_viewpager);
        AddDataPagerAdapter pagerAdapter = new AddDataPagerAdapter(getSupportFragmentManager());
        //联系viewpager和pageAdapter
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.add_data_sliding_tabs);
        //绑定tabLayout和当前的viewPager,滑动后一起联动
        tabLayout.setupWithViewPager(viewPager);

        List<StudentInformation> stuInfor =LitePal.findAll(StudentInformation.class);
        for (StudentInformation s:stuInfor){
            Log.i("看着666666",s.getStuId()+","+s.getStuName()+",");
        }
        List<InstructorInformation> aa =LitePal.findAll(InstructorInformation.class);
        for (InstructorInformation s:aa){
            Log.i("看着55555555555",s.getInsId()+","+s.getInsName()+",");
        }
        //关键

        //查询数据
        //List<StudentInformation> stuInfor =LitePal.findAll(StudentInformation.class);
        /*for (StudentInformation s:stuInfor){
            TextView stuId = (TextView)findViewById(R.id.stuId);
            TextView stuName = (TextView)findViewById(R.id.stuName);
            TextView stuPassword = (TextView)findViewById(R.id.stuPassword);
            TextView college = (TextView)findViewById(R.id.college);
            TextView major = (TextView)findViewById(R.id.major);
            TextView grade = (TextView)findViewById(R.id.grade);
            stuId.setText(s.getStuId()+"");//因为是int类型的
            stuName.setText(s.getStuName());
            stuPassword.setText(s.getStuPassword());
            college.setText(s.getCollege());
            major.setText(s.getMajor());
            grade.setText(s.getGrade());
            Log.i(">>>>>>>>>>>",s.getStuId()+""+s.getStuName());
        }*/
    }

    //用于实例化数据库对象并添加数据
    //SQLiteDatabase db =  LitePal.getDatabase();
    //添加测试数据
    public void stu_supply(View view){
        EditText stuId = (EditText)findViewById(R.id.stuId);
        EditText stuName = (EditText)findViewById(R.id.stuName);
        EditText stuPassword = (EditText)findViewById(R.id.stuPassword);
        EditText college = (EditText)findViewById(R.id.college);
        EditText major = (EditText)findViewById(R.id.major);
        EditText grade = (EditText)findViewById(R.id.grade);
        /*全部不为空的时候，写入学生信息数据库*/
        /*if (stuId.getText()!=null&&stuName.getText()!=null&stuPassword.getText()!=null&&college.getText()
                !=null&&major.getText()!=null&grade.getText()!=null){*/
            //添加数据
        StudentInformation studentInformation = new StudentInformation();
        int stu_id = Integer.parseInt(stuId.getText().toString())+0;
        studentInformation.setStuId(stu_id);
        studentInformation.setStuName(stuName.getText().toString());
        studentInformation.setStuPassword(stuPassword.getText().toString());
        studentInformation.setCollege(college.getText().toString());
        studentInformation.setMajor(major.getText().toString());
        studentInformation.setGrade(grade.getText().toString());
        studentInformation.save();
        Toast.makeText(AddData.this,"成功写入学生数据",Toast.LENGTH_SHORT).show();
        stuId.setText(null);
            stuName.setText(null);
            stuPassword.setText(null);
            college.setText(null);
            major.setText(null);
            grade.setText(null);
            List<StudentInformation> stuInfor =LitePal.findAll(StudentInformation.class);
            for (StudentInformation s:stuInfor){
                Log.i("看着1111",s.getStuId()+","+s.getStuName()+",");
            //}
        }
        List<InstructorInformation> instructorInformation =LitePal.findAll(InstructorInformation.class);
        for (InstructorInformation s:instructorInformation){
            Log.i("看着1111",s.getInsId()+","+s.getInsPassword()+",");
            //}
        }
        /*else {
            Toast.makeText(AddData.this,"发生错误，学生数据不能为空",Toast.LENGTH_LONG).show();
            List<StudentInformation> stuInfor =LitePal.findAll(StudentInformation.class);
            for (StudentInformation s:stuInfor){
                Log.i("看着222222",s.getStuId()+","+s.getStuName()+",");
            }*/
        }

    public void ins_supply(View view) {
        EditText insId = (EditText) findViewById(R.id.insId);
        EditText insName = (EditText) findViewById(R.id.insName);
        EditText insPassword = (EditText) findViewById(R.id.insPassword);
        EditText insGrade = (EditText) findViewById(R.id.insGrade);
        /*全部不为空的时候，写入学生信息数据库*/
       // if (insId.getText() != null && insName.getText() != null & insPassword.getText() != null && insGrade.getText() != null) {
            //添加数据
            InstructorInformation instructorInformation = new InstructorInformation();
            int stu_id = Integer.parseInt(insId.getText().toString())+0;
            instructorInformation.setInsId(stu_id);
            instructorInformation.setInsName(insName.getText().toString());
            instructorInformation.setInsPassword(insPassword.getText().toString());
            instructorInformation.setInsGrade(insGrade.getText().toString());
            instructorInformation.save();
            Toast.makeText(AddData.this, "成功写入辅导员数据", Toast.LENGTH_SHORT).show();
            insId.setText(null);
            insName.setText(null);
            insPassword.setText(null);
            insGrade.setText(null);
            //查询数据
            /*List<InstructorInformation> stuInfor =LitePal.findAll(InstructorInformation.class);
        for (InstructorInformation s:stuInfor){
            Log.i(">>>>>>>>>>>",s.getInsId()+","+s.getInsName()+","+s.getInsPassword()+s.getInsGrade());
        }
        } else {
            Toast.makeText(AddData.this, "发生错误，辅导员数据不能为空", Toast.LENGTH_LONG).show();
            List<InstructorInformation> stuInfor =LitePal.findAll(InstructorInformation.class);
            for (InstructorInformation s:stuInfor){
                Log.i("卡机斯达舒3333333333",s.getInsId()+","+s.getInsName()+","+s.getInsPassword()+s.getInsGrade());
            }*/
    }
}
