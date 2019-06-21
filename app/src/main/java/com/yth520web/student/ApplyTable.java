package com.yth520web.student;

import org.litepal.crud.LitePalSupport;

public class ApplyTable extends LitePalSupport {

    /**
     *申请表
     */
    int stuId;//新增
    String stuName;//新增
    String majoy;//新增
    String applyTableNum;//申请单编号
    int insId;//辅导员工号
    String applyDay;//申请日期
    String applyHour;//申请时长
    String applyReason;//申请原因
    String peopleNum;//申请的总人数

    public ApplyTable(int stuId,String stuName,String majoy){
        this.stuId=stuId;
        this.stuName=stuName;
        this.majoy=majoy;
    }
    public ApplyTable(){
    }
    public String getApplyTableNum() {
        return applyTableNum;
    }

    public void setApplyTableNum(String applyTableNum) {
        this.applyTableNum = applyTableNum;
    }

    public int getInsId() {
        return insId;
    }

    public void setInsId(int insId) {
        this.insId = insId;
    }

    public String getApplyDay() {
        return applyDay;
    }

    public void setApplyDay(String applyDay) {
        this.applyDay = applyDay;
    }

    public String getApplyHour() {
        return applyHour;
    }

    public void setApplyHour(String applyHour) {
        this.applyHour = applyHour;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
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

    public String getMajoy() {
        return majoy;
    }

    public void setMajoy(String majoy) {
        this.majoy = majoy;
    }
}
