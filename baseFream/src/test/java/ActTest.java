import org.activiti.engine.*;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 会默认按照Resources目录下的activiti.cfg.xml创建流程引擎
     */
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Test
    public void test() { //以下两种方式选择一种创建引擎方式：1.配置写在程序里 2.读对应的配置文件
        logger.info("工作流启动....");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("apply", "zhangsan");
        map.put("approve", "lisi");
        // 流程启动
        ExecutionEntity pi1 = (ExecutionEntity) runtimeService.startProcessInstanceByKey("myProcess_1", map);

        /*String processId = pi1.getId();
        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        logger.info("task 第一步:{}", task);
        taskService.complete(task.getId(), map);// 完成第一步申请

        task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        logger.info("task 第二步:{}", task);
        String taskId2 = task.getId();
        map.put("pass", false);
        taskService.complete(taskId2, map);// 驳回申请

        task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        logger.info("task 第三步:{}", task);
        logger.info("工作流结束....");*/

    }

    /**
     * 测试activiti环境
     */
    @Test
    public void testCreateProcessEngine() {
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        cfg.setJdbcDriver("com.mysql.jdbc.Driver");
        cfg.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/activiti");
        cfg.setJdbcUsername("root");
        cfg.setJdbcPassword("root"); //配置建表策略
        cfg.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine engine = cfg.buildProcessEngine();
    }

    /**
     * 根据配置文件activiti.cfg.xml创建ProcessEngine
     */
    @Test
    public void testCreateProcessEngineByCfgXml() {
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine engine = cfg.buildProcessEngine();
    }

    /**
     * 发布流程
     * RepositoryService
     */
    @Test
    public void deployProcess() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder builder = repositoryService.createDeployment();
        builder.addClasspathResource("processes/test.bpmn");
        builder.deploy();
    }

    /**
     * 启动流程
     * <p>
     * RuntimeService
     */
    @Test
    public void startProcess() {
        RuntimeService runtimeService = processEngine.getRuntimeService();
//可根据id、key、message启动流程
        runtimeService.startProcessInstanceByKey("myProcess_1");
    }

    /**
     * 查看任务
     * TaskService
     */
    @Test
    public void queryTask() {
        TaskService taskService = processEngine.getTaskService(); //根据assignee(代理人)查询任务
        String assignee = "emp";
        List<Task> tasks = taskService.createTaskQuery().list();
        int size = tasks.size();
        for (int i = 0; i < size; i++) {
            Task task = tasks.get(i);
        }
        for (Task task : tasks) {
            System.out.println("taskId:" + task.getId() + ",taskName:" + task.getName() + ",assignee:" + task.getAssignee() + ",createTime:" + task.getCreateTime());
        }
    }

    /**
     * 办理任务
     */
    @Test
    public void handleTask() {
        TaskService taskService = processEngine.getTaskService(); //根据上一步生成的taskId执行任务
        String taskId = "2504";
        taskService.complete(taskId);
    }

}
