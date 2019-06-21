package com.yth520web.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class AnPai extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anpai);
        final TextView anpai_AA = (TextView)findViewById(R.id.anpai_AA);
        final TextView anpai_BB = (TextView)findViewById(R.id.anpai_BB);
        final TextView anpai_CC = (TextView)findViewById(R.id.anpai_CC);
        final EditText anpaijiaoshi = (EditText)findViewById(R.id.anpaijiaoshi);
        final EditText anpaishijian = (EditText)findViewById(R.id.anpaishijian);
        Intent intent = getIntent();
        final String applyTableNum = intent.getStringExtra("applyTableNum");
        List<ApplyTable> applyTables = LitePal.where("applyTableNum=?",applyTableNum)
                .find(ApplyTable.class);
        for (ApplyTable a:applyTables){
            anpai_AA.setText(a.getApplyDay()+"");
            anpai_BB.setText(a.getApplyHour()+"");
            anpai_CC.setText(a.getPeopleNum()+"");
            Log.i("安排》》》",a.getClass()+a.getApplyHour()+a.getPeopleNum());
        }
        Button tijiao = (Button)findViewById(R.id.tijiao);

        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplyProcess applyProcess = new ApplyProcess();
                applyProcess.setIsOfficePass("通过");
                applyProcess.setArrangeClass(anpaijiaoshi.getText().toString());
                applyProcess.setArrangeHour(anpaishijian.getText().toString());
                applyProcess.updateAll("applyTableNum=?",applyTableNum);
                Log.i("AnPai》》》","成功");
                Toast.makeText(AnPai.this, "安排上了！！" , Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
