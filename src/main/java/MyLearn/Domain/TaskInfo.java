package MyLearn.Domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: TaskInfo
 * @Description: mpp任务实体类
 * @Company: www.leador.com.cn
 * @Date: 2019-09-04 14:45
 * @author: wangjiyuan
 * @Version: 1.0
 **/
@Setter
@Getter
public class TaskInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int projectId; // 所属项目ID
    private int taskId;	// 任务ID
    private int taskUniqueId;// 任务唯一ID
    private int parentId;// 父任务ID
    private int taskOutlineLevel;// 任务级别
    private String taskName;// 任务名称
    private double taskDuration;// 任务工期
    private Date taskStartDate;// 任务开始时间
    private Date taskFinishDate;// 任务结束时间
    private String taskPredecessors;// 任务流,前置任务
    private String taskOperator;// 负责人
    private String taskResourceNames; //资源名称
    private String taskYzfxzsx; //业主方协助事项，自定义字段Text2
    private String taskBz; //备注，自定义字段Text1
}
