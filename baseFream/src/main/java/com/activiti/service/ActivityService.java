package com.activiti.service;

import com.activiti.vo.TaskVo;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

public interface ActivityService {

    /**
     * 启动工作流
     * @Param processInstanceKey 工作流实例名
     * @return 实例id
     */
    public String startActivity(String processInstanceKey, Map<String, Object> map);


    /**
     * 查看所有任务
     */
    public List<TaskVo> queryActivity();

    /**
     * 办理任务
     */
    public void handleTask(String processId,Map<String, Object> map);
}
