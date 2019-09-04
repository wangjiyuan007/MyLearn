package MyLearn.Demo;

import MyLearn.Domain.TaskInfo;
import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Relation;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpp.MPPReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title: MppReader
 * @Description: 解析本地mpp文件
 * @Company: www.leador.com.cn
 * @Date: 2019-09-04 15:48
 * @author: wangjiyuan
 * @Version: 1.0
 **/
public class MppReader {
    public static void main(String[] args) {
        List<TaskInfo> taskInfoList = readFile();
        System.out.println(taskInfoList);
    }

    public static List<TaskInfo> readFile(){

        List<TaskInfo> taskList = new ArrayList<>();
        try{
            File file = new File("E:\\WJY\\拜泉县数字化城市管理系统地理空间信息数据建设项目计划.mpp");
            MPPReader mppRead = new MPPReader();
            ProjectFile pf = mppRead.read(file);
            System.out.println("MPXJUtils.method [readFile]: fileName-" + file.getName());
            List<Task> tasks = pf.getAllTasks();
            System.out.println("MPXJUtils.method [readFile]: taskSize-" + tasks.size());

            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
//                Integer parentId = 0;
//                if (task.getParentTask() != null){
//                    parentId = task.getParentTask().getID();
//                }
                Integer taskId = task.getID();
                String taskName = task.getName();
                Integer taskUniqueId = task.getUniqueID();
                Integer taskOutlineLevel = task.getOutlineLevel();
                double taskDuration = task.getDuration().getDuration();
                Date taskStartDate = task.getStart();
                Date taskFinishDate = task.getFinish();
                String taskYzfxzsx = task.getText(2);
                String taskBz = task.getText(1);
                List<Relation> taskPredecessors = task.getPredecessors();
                System.out.println("MPXJUtils.method [readFile] taskInfo:" + taskId + "|" + taskName + "|" + taskUniqueId + "|" + taskOutlineLevel + "|"
                        + taskDuration + "|" + taskStartDate + "|" + taskFinishDate + "|" + taskPredecessors + "|" + taskYzfxzsx + "|" + taskBz);

                // 封装TaskInfo
//                java.sql.Date sqlStartDate = Str2Date.getUKDate(taskStartDate.toString());			// StartDate转换
//                java.sql.Date sqlFinishDate = Str2Date.getUKDate(taskFinishDate.toString());			// FinishDate转换
                StringBuffer sb = new StringBuffer();
                if(taskPredecessors != null){
                    if(taskPredecessors.size() > 0){
                        for(Relation relation : taskPredecessors){
                            Integer targetTaskId = relation.getTargetTask().getID();
                            if(sb.length() == 0){
                                sb.append(targetTaskId);
                            }else{
                                sb.append(","+targetTaskId);
                            }
                        }
                    }
                }
                String task_predecessors_str = sb.toString();											// 任务流文本

                TaskInfo taskInfo = new TaskInfo();
                taskInfo.setTaskId(taskId);
//                taskInfo.setParentId(parentId);
                taskInfo.setTaskName(taskName);
                taskInfo.setTaskUniqueId(taskUniqueId);
                taskInfo.setTaskOutlineLevel(taskOutlineLevel);
                taskInfo.setTaskDuration(taskDuration);
                taskInfo.setTaskStartDate(taskStartDate);
                taskInfo.setTaskFinishDate(taskFinishDate);
                taskInfo.setTaskPredecessors(task_predecessors_str);
                taskInfo.setTaskYzfxzsx(taskYzfxzsx);
                taskInfo.setTaskBz(taskBz);

                taskList.add(taskInfo);
            }
        }catch (MPXJException e) {
            System.out.println("MPXJUtils.method [readFile]: MPXJException-" + e);
            return null;
        } catch (Exception e) {
            System.out.println("MPXJUtils.method [readFile]: MPXJException-" + e);
            return null;
        }
        return taskList;
    }
}
