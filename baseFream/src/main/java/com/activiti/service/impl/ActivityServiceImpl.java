package com.activiti.service.impl;

import com.activiti.service.ActivityService;
import com.activiti.vo.TaskVo;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Override
    public String startActivity(String processInstanceKey,Map<String, Object> map) {
        logger.info("工作流启动....");

        // 流程启动
        ExecutionEntity pi1 = (ExecutionEntity) runtimeService.startProcessInstanceByKey(processInstanceKey,map);
        String processId = pi1.getId();
        return processId;
        // ExecutionEntity pi1 = (ExecutionEntity) runtimeService.startProcessInstanceByKey("myProcess_1", map);

       /* String processId = pi1.getId();
        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        logger.info("task 第一步:{}", task);
        taskService.complete(task.getId(), map);*/// 完成第一步申请


        /*task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        logger.info("task 第二步:{}", task);
        String taskId2 = task.getId();
        map.put("pass", false);
        taskService.complete(taskId2, map);// 驳回申请

        task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        logger.info("task 第三步:{}", task);
        logger.info("工作流结束....");*/
    }

    @Override
    public List<TaskVo> queryActivity() {
        List<Task> tasks = taskService.createTaskQuery().list();

      //  List<Task> tasks = taskService.createTaskQuery().taskCandidateOrAssigned("zhangsan2333").list();
        List<TaskVo> list=new ArrayList<TaskVo>();
        TaskVo taskVo=null;
        for (Task task : tasks) {
            System.out.println("taskId:" + task.getId() + ",taskName:" + task.getName() + ",assignee:" + task.getAssignee() + ",createTime:" + task.getCreateTime());
            taskVo= new TaskVo();
            taskVo.setProcessInstanceId(task.getProcessInstanceId());
            taskVo.setTaskId(task.getId() );
            taskVo.setTaskName(task.getName());
            taskVo.setAssignee(task.getAssignee());
            taskVo.setCreateTime(task.getCreateTime());
            Object apply=taskService.getVariable(task.getId(),"apply");//根据任务id获取流程中的变量
            Object approve=taskService.getVariable(task.getId(),"approve");//根据任务id获取流程中的变量
            taskVo.setApply(apply+"");
            taskVo.setApprove(approve+"");
            list.add(taskVo);
        }
        return list;
    }

    @Override
    public void handleTask(String processId,Map<String, Object> map) {
        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        taskService.complete(task.getId(),map);
        logger.info("task 当前完成节点:{}", task.getName());
    }
}