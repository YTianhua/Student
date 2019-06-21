package com.yth520web.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ApplyProcessAdapter extends ArrayAdapter {
    public int resourceId;
    public ApplyProcessAdapter(Context context, int resourceId, List<ApplyProcess> objects) {
        super(context, resourceId,objects);
        this.resourceId=resourceId;//记得写这句话
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        ApplyProcess applyProcess = (ApplyProcess) getItem(position);//获得当前项的ApplyProcess实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView applyTableNum = (TextView)view.findViewById(R.id.applyTableNum);
        TextView isInsPass = (TextView)view.findViewById(R.id.isInsPass);
        TextView isOfficePass = (TextView)view.findViewById(R.id.isOfficePass);
        TextView arrangeClass = (TextView)view.findViewById(R.id.arrangeClass);
        TextView arrangeHour = (TextView)view.findViewById(R.id.arrangeHour);

        applyTableNum.setText(applyProcess.getApplyTableNum());
        isInsPass.setText(applyProcess.getIsInsPass());
        isOfficePass.setText(applyProcess.getIsOfficePass());
        arrangeClass.setText(applyProcess.getArrangeClass());
        arrangeHour.setText(applyProcess.getArrangeHour());
        return view;
    }
}
