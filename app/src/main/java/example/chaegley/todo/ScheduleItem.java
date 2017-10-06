package example.chaegley.todo;

import java.util.ArrayList;


public class ScheduleItem {

    private String title; //title of task
    private String dueDate; // date task is due
    private String description; //description of task
    private String notes; //description of task
    private boolean finished; //whether or not the task is completed
    private int completion; //percentage completed of task
    private int weight; //how important the task is
    private ArrayList<ScheduleItem> subtask = null;


    public ScheduleItem(String title, String dueDate, String description, String notes, int completion, int weight) {
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
        this.notes = notes;
        this.finished = false;
        this.setCompletion(completion);
        this.setWeight(weight);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getCompletion() {
        return completion;
    }

    public void setCompletion(int c) {
        if(c<0){
            c=0;
        }
        if(c>100){
            c=100;
        }
        this.completion = c;
    }

    public ScheduleItem getSubtask(int position) {
        return subtask.get(position);
    }

    public void setSubtask(ScheduleItem task) {
        subtask.add(task);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int w) {
        if(w<1){
            w=1;
        }
        if(w>5){
            w=5;
        }
        this.weight = w;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
