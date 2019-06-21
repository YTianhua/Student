package com.yth520web.student;
import org.litepal.crud.LitePalSupport;
import org.litepal.crud.LitePalSupport;

public class StudentApply extends LitePalSupport {
    /**
     * 学生申请表
     */
    int applyId;//申请序号
    int stuId;//学生学号
    String stuName;
    String applyTableNum;//申请单编号

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getApplyTableNum() {
        return applyTableNum;
    }

    public void setApplyTableNum(String applyTableNum) {
        this.applyTableNum = applyTableNum;
    }
}
