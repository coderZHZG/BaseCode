package com.activiti.controller;

import com.Util.ActUtils;
import com.activiti.service.ActivityService;
import com.activiti.vo.TaskVo;
import com.entity.User;
import com.service.UserService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhiguo on 2018/12/4.
 */

@RequestMapping("/act")
@Controller
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @RequestMapping(value = "/list")
    public String count(ModelMap map){
        Map<String, Object> maps =new HashMap<>();
        List<TaskVo> actList=activityService.queryActivity();
        map.addAttribute("actList",actList);
        return "actList";
    }

    @RequestMapping(value = "/getFlowImg/{processInstanceId}")
    public void getFlowImgByInstantId(@PathVariable("processInstanceId") String processInstanceId, HttpServletResponse response) {
        try {
            System.out.println("processInstanceId:" + processInstanceId);
            ActUtils.getFlowImgByInstanceId(processInstanceId, response.getOutputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
