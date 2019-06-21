package com.yth520web.student;

import org.litepal.crud.LitePalSupport;

public class ApplyProcess extends LitePalSupport {


    /**
     * 申请进度表
     */
    int applyId;//申请序号，作为主码不重样
    int stuId;//新增
    String applyTableNum;//申请单编号
    String isInsPass;//辅导员是否通过
    String isOfficePass;//教务处是否通过
    String arrangeClass;//安排的教室
    String arrangeHour;//安排的时间段

    public ApplyProcess(String applyTableNum,String isInsPass,String isOfficePass,String arrangeClass,
                        String arrangeHour){
        this.applyTableNum = applyTableNum;
        this.isInsPass = isInsPass;
        this.isOfficePass = isOfficePass;
        this.arrangeClass = arrangeClass;
        this.arrangeHour = arrangeHour;

    }
    public ApplyProcess(){}
    public int getApplyId() {
        return applyId;
    }
    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }
    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public String getApplyTableNum() {
        return applyTableNum;
    }

    public void setApplyTableNum(String applyTableNum) {
        this.applyTableNum = applyTableNum;
    }

    public String getIsInsPass() {
        return isInsPass;
    }

    public void setIsInsPass(String isInsPass) {
        this.isInsPass = isInsPass;
    }

    public String getIsOfficePass() {
        return isOfficePass;
    }

    public void setIsOfficePass(String isOfficePass) {
        this.isOfficePass = isOfficePass;
    }

    public String getArrangeClass() {
        return arrangeClass;
    }

    public void setArrangeClass(String arrangeClass) {
        this.arrangeClass = arrangeClass;
    }

    public String getArrangeHour() {
        return arrangeHour;
    }

    public void setArrangeHour(String arrangeHour) {
        this.arrangeHour = arrangeHour;
    }
}
