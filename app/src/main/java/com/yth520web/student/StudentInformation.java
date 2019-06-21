package com.yth520web.student;

import org.litepal.crud.LitePalSupport;

public class StudentInformation extends LitePalSupport {
    int stuId;//学号
    String stuName;//姓名
    String stuPassword;//学生密码
    String college;//学院
    String major;//专业
    String grade;//年级

    public int getStuId() {
        return stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public String getCollege() {
        return college;
    }

    public String getMajor() {
        return major;
    }

    public String getGrade() {
        return grade;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
