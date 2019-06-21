package com.yth520web.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class OfficeCheckAdapter extends ArrayAdapter {
    public int resourceId;
    public OfficeCheckAdapter(Context context, int resourceId, List<OfficeCheckBean> objects) {
        super(context, resourceId,objects);
        this.resourceId=resourceId;//记得写这句话
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        OfficeCheckBean officeCheckBean = (OfficeCheckBean) getItem(position);//获得当前项的ApplyProcess实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView office_check_stuName = (TextView)view.findViewById(R.id.office_check_applyTableNum);
        office_check_stuName.setText(officeCheckBean.getApplyTableNum());
        return view;
    }
}
