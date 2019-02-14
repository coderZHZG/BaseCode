package com.activiti.vo;

import java.util.Date;

public class TaskVo {
    private String processInstanceId;
    private String taskId;
    private String taskName;
    private String assignee;//当前节点处理人
    private Date createTime;
    private String apply;//提交人
    private String approve;//审批人

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getApply() {
        return apply;
    }

    public void setApply(String apply) {
        this.apply = apply;
    }

    public String getApprove() {
        return approve;
    }

    public void setApprove(String approve) {
        this.approve = approve;
    }
}
