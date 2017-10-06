package example.chaegley.todo;

import java.util.ArrayList;


public class ActivityList {
    private static ActivityList instance = new ActivityList();
    private ArrayList<ScheduleItem> taskList;

    private ActivityList(){
        taskList = new ArrayList<ScheduleItem>();
    };

    public static ActivityList getInstance(){
        return instance;
    }

    public ScheduleItem getTask(int position){
        return taskList.get(position);
    }

    public void addTask(ScheduleItem shed){
        taskList.add(shed);
    }

    public void removeTask(int position){
        taskList.remove(position);
    }

    public void updateList(ArrayList<ScheduleItem> array){
        taskList = array;
    }

    public ArrayList<ScheduleItem> getTaskList(){
        return taskList;
    }
}
