package com.yth520web.student;

import org.litepal.crud.LitePalSupport;

public class InstructorInformation extends LitePalSupport {
    //辅导员信息表
    int insId;//工号
    String insName;//辅导员姓名
    String insPassword;
    String insGrade;//辅导员管理的年级，可能其他学院同一年级有多个辅导员

    public void setInsId(int insId) {
        this.insId = insId;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public void setInsPassword(String insPassword) {
        this.insPassword = insPassword;
    }

    public void setInsGrade(String insGrade) {
        this.insGrade = insGrade;
    }

    public int getInsId() {
        return insId;
    }

    public String getInsName() {
        return insName;
    }

    public String getInsPassword() {
        return insPassword;
    }

    public String getInsGrade() {
        return insGrade;
    }
}
