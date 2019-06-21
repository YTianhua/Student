package com.yth520web.student;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.Calendar;
import java.util.List;

public class Student extends AppCompatActivity {
    Intent intent;
    String stuMajor=null;
    public int stuId=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        StudentPagerAdapter pagerAdapter = new StudentPagerAdapter(getSupportFragmentManager());
        //联系viewpager和pageAdapter
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        //绑定tabLayout和当前的viewPager,滑动后一起联动
        tabLayout.setupWithViewPager(viewPager);
        //stuId = Integer.parseInt(intent.getStringExtra("stuId"));
        View view1 = LayoutInflater.from(this).inflate(R.layout.fragment_student_apply, null);
        TextView hello_stu = (TextView) view1.findViewById(R.id.hello_stu);
        intent = getIntent();

        String str = intent.getStringExtra("stuName");
        hello_stu.setText("Hello!" + str);
        Log.i("Hell", str);
        List<ApplyProcess> aa = LitePal.findAll(ApplyProcess.class);
        for (ApplyProcess s : aa) {
            ApplyProcess applyProcess = new ApplyProcess(s.getApplyTableNum(), s.getIsInsPass(),
                    s.getIsOfficePass(), s.getArrangeClass(), s.getArrangeHour());
            Log.i("检验applyProcess222222", s.getApplyTableNum() + "" + s.getIsInsPass() + "" +
                    s.getIsOfficePass() + "" + s.getArrangeClass() + "" + s.getArrangeHour());
        }
        EditText applyDay = view1.findViewById(R.id.applyDay);
        applyDay.setText("23333");
        Log.i("获得申请时间",applyDay.getText().toString());
    }
        protected void showDatePickDlg() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(Student.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
               // Student.this.applyDay.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
            }
            }
            , calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }
    public void student_apply(View view) {
        //随机生成一个申请单编号
        String randomTableNum[]={"XN-","WN-","YZ-","UX-","PNH-","XJ-"};
        int randomNum = (int) (Math.random()*100000);
        int randomT = (int)(6*Math.random());
        String applyTableNum= randomTableNum[randomT]+randomNum;
        Log.i("随机生成的申请单编号：",applyTableNum);
        EditText stu_ins = (EditText)findViewById(R.id.stu_ins);//辅导员
        EditText applyDay = (EditText)findViewById(R.id.applyDay);//申请日期
        EditText applyHour = (EditText)findViewById(R.id.applyHour);//申请时长
        EditText applyReason = (EditText)findViewById(R.id.applyReason);//申请原因
        EditText peopleNum = (EditText)findViewById(R.id.peopleNum);//申请人数
        //需要往StudentApply和ApplyTable和ApplyProcess填入数据
        try {
            if (stu_ins.getText().toString() != null && applyDay.getText().toString() != null
                    && applyHour.getText().toString() != null && applyReason.getText().toString() != null
                    && peopleNum.getText().toString() != null) {
                StudentApply studentInformation = new StudentApply();
                studentInformation.setApplyId(randomNum);//随便填的一个
                studentInformation.setStuId(Integer.parseInt(intent.getStringExtra("stuId")));//Id
                studentInformation.setStuName(intent.getStringExtra("stuName"));
                studentInformation.setApplyTableNum(applyTableNum);
                studentInformation.save();

                //获取学生的专业信息
                List<StudentInformation> si  =LitePal.where("stuId=?",""+Integer.parseInt(intent.getStringExtra("stuId")))
                        .find(StudentInformation.class);
                for (StudentInformation xxx:si){
                    Log.i("获得专业信息：",xxx.getMajor());
                    stuMajor = xxx.getMajor();


                }
                ApplyTable applyTable = new ApplyTable(0,null,null);
                applyTable.setStuId(Integer.parseInt(intent.getStringExtra("stuId")));
                applyTable.setStuName(intent.getStringExtra("stuName"));
                applyTable.setMajoy(stuMajor);
                applyTable.setApplyTableNum(applyTableNum);//申请单编号
                applyTable.setInsId(Integer.parseInt(stu_ins.getText().toString()));//辅导员工号
                applyTable.setApplyDay(applyDay.getText().toString());
                applyTable.setApplyHour(applyHour.getText().toString());
                applyTable.setApplyReason(applyReason.getText().toString());
                applyTable.setPeopleNum(peopleNum.getText().toString());
                applyTable.save();

                ApplyProcess applyProcess = new ApplyProcess(applyTableNum, "否", "否", null, null);
                applyProcess.setApplyTableNum(applyTableNum);
                applyProcess.setStuId(Integer.parseInt(intent.getStringExtra("stuId")));
                applyProcess.setIsInsPass("待审核");
                applyProcess.setIsOfficePass("待审核");
                applyProcess.setArrangeHour(null);
                applyProcess.setArrangeClass(null);
                applyProcess.save();
                List<ApplyProcess> aa = LitePal.findAll(ApplyProcess.class);
                if (aa!=null) {
                    for (ApplyProcess s : aa) {
                        Log.i("测试是否提交成功到ApplyProcess", s.getApplyTableNum() + "," + s.getIsInsPass() + ",");
                        //}
                    }
                }
                Toast.makeText(Student.this, "成功提交申请单", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Student.this, "数据不能为空", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            Log.i("发生未知错误：",e+"");
        }
    }
}
