package com.yth520web.student;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.yth520web.student.R;

import org.litepal.LitePal;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String administrator="administrator";
    String administratorPassword="123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView user = (TextView)findViewById(R.id.user);
        final TextView password = (TextView)findViewById(R.id.password);
        //解决LinearLayout的背景图片被拉伸的问题;
        RadioButton radioStudent = (RadioButton)findViewById(R.id.radioStudent);
        RadioButton radioInstratir = (RadioButton)findViewById(R.id.radioInstratir);
        radioStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().equals(administrator)
                        && password.getText().toString().equals(administratorPassword)) {
                    Intent intent = new Intent(MainActivity.this, OfficeCheck.class);
                    startActivity(intent);
                    return;
                }
                if (user.getText().toString() == null
                        && password.getText().toString() == null){
                    Toast.makeText(MainActivity.this, "请输入账号和密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                    //学生登陆的if
                    List<StudentInformation> studentInformation = LitePal.findAll(StudentInformation.class);
                    //遍历数据库，查询
                    for (StudentInformation s : studentInformation) {
                        //教务处的if
                        if ((Integer.parseInt(user.getText().toString()) == (s.getStuId())) && (password.getText().toString().equals(s.getStuPassword()))) {
                            Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, Student.class);
                            intent.putExtra("stuName", s.getStuName());
                            intent.putExtra("stuId", s.getStuId() + "");
                            SharedPreferences preferences = getSharedPreferences("文件名", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("log",s.getStuId()+"" );
                            editor.commit();
                            /*SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                            editor.putString("stuId",s.getStuId()+"");
                            editor.apply();*/
                            Intent x = new Intent(MainActivity.this, StudentCheckFragment.class);
                            x.putExtra("stuId", s.getStuId() + "");
                            startActivity(intent);
                            break;
                        } else {
                            Toast.makeText(MainActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });
        radioInstratir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().equals(administrator)
                        &&password.getText().toString().equals(administratorPassword)) {
                    Intent intent = new Intent(MainActivity.this, OfficeCheck.class);
                    startActivity(intent);
                    return;
                }
                if (user.getText().toString() == null
                        || password.getText().toString() == null){
                    Toast.makeText(MainActivity.this, "请输入账号和密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                List<InstructorInformation> instructorInformation = LitePal.findAll(InstructorInformation.class);
                for (InstructorInformation s:instructorInformation){
                   //教务处的if
                    if ((Integer.parseInt(user.getText().toString())==(s.getInsId()))&&(password.getText().toString().equals(s.getInsPassword()))){
                        Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(MainActivity.this,Instructor.class);
                        intent.putExtra("insId",s.getInsId()+"");
                        startActivity(intent);
                        break;
                    }else {
                        Toast.makeText(MainActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
