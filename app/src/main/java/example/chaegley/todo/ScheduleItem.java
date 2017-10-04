package example.chaegley.todo;

/**
 * Created by chaegley on 9/22/17.
 */

public class ScheduleItem {

    private String title; //title of task
    private String dueDate; // date task is due
    private String description; //description of task
    private boolean finished; //whether or not the task is completed
    private int completion; //percentage completed of task


    public ScheduleItem(String title, String dueDate, String description, boolean finished, int completion) {
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
        this.finished = finished;
        this.completion = completion;
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

    public void setCompletion(int completion) {
        this.completion = completion;
    }
}
