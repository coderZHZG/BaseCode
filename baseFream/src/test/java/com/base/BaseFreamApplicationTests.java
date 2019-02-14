package com.base;

import com.activiti.service.ActivityService;
import com.activiti.vo.TaskVo;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseFreamApplicationTests {

	@Resource(name = "activityService")
	private ActivityService activityService;

	@Test
	public void contextLoads() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("apply", "郝全康");
		map.put("approve", "王彬鹏");
		String pressid=activityService.startActivity("oa",map);
		System.out.println(pressid);
	}

	@Test
	public void contextLoads1() {
		List<TaskVo> tasks= activityService.queryActivity();
		int size = tasks.size();
		/*for (int i = 0; i < size; i++) {
			Task task1 = tasks.get(i);
		}
		for (Task task2 : tasks) {

			System.out.println(" ProcessInstanceId : "+task2.getProcessInstanceId()+",taskId:" + task2.getId() + ",taskName:" + task2.getName() + ",assignee:" + task2.getAssignee() + ",createTime:" + task2.getCreateTime());
		}*/
	}

	@Test
	public void contextLoads2() {
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("approve", "zhaoliu");
		map.put("pass", true);
		activityService.handleTask("37501",map);
		contextLoads1();
	}
}
