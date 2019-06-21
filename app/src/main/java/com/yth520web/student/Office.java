package com.yth520web.student;

import org.litepal.crud.LitePalSupport;

public class Office extends LitePalSupport {
    /**
     * 教务处
     */
//    包括申请单编号：applyTableNum
//    申请日期：applyDay
//    申请时长：applyHour
//    人数：peopleNum
//    是否通过申请：isOfficePass
    String applyTableNum;//申请单编号
    String applyDay;//申请日期
    String applyHour;//申请时长
    String peopleNum;//人数

    public String getApplyTableNum() {
        return applyTableNum;
    }

    public void setApplyTableNum(String applyTableNum) {
        this.applyTableNum = applyTableNum;
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

    public String getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getIsOfficePass() {
        return isOfficePass;
    }

    public void setIsOfficePass(String isOfficePass) {
        this.isOfficePass = isOfficePass;
    }

    String isOfficePass;//是否通过申请
}
