package com.yth520web.student;

import org.litepal.crud.LitePalSupport;

public class InstructorCheck extends LitePalSupport {
    /**
     * 辅导员审查表
     */
    int applyId;//审查序号，作为主码不重样
    int insNum;//辅导员工号
    String applyTableNum;//申请单编号
    String isInsPass;//辅导员是否通过

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public int getInsNum() {
        return insNum;
    }

    public void setInsNum(int insNum) {
        this.insNum = insNum;
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
}
