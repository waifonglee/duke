package duke.task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deleteTask(int ind) {
        taskList.remove(ind);
    }

    public Task getTask(int ind) {
        return taskList.get(ind);
    }

    public int getSize() {
        return taskList.size();
    }
}
