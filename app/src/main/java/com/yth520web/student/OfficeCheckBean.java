package com.yth520web.student;

public class OfficeCheckBean {
    String applyTableNum;
    public OfficeCheckBean(String stuName){
        this.applyTableNum=stuName;

    }

    public String getApplyTableNum() {
        return applyTableNum;
    }

    public void setApplyTableNum(String applyTableNum) {
        this.applyTableNum = applyTableNum;
    }
}
