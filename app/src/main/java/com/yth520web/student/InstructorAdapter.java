package com.yth520web.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class InstructorAdapter extends ArrayAdapter {
    public int resourceId;
    public InstructorAdapter(Context context, int resourceId, List<ApplyTable> objects) {
        super(context, resourceId,objects);
        this.resourceId=resourceId;//记得写这句话
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        ApplyTable applyTable = (ApplyTable) getItem(position);//获得当前项的ApplyProcess实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView ins_check_major = (TextView)view.findViewById(R.id.ins_check_major);
        TextView ins_check_stuName = (TextView)view.findViewById(R.id.ins_check_stuName);
        TextView ins_check_stuId = (TextView)view.findViewById(R.id.ins_check_stuId);

        ins_check_major.setText(applyTable.getMajoy()+"");
        ins_check_stuName.setText(applyTable.getStuName());
        ins_check_stuId.setText(applyTable.getStuId()+"");
        return view;
    }
}
