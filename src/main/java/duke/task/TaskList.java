package duke.task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int ind) {
        tasks.remove(ind);
    }

    public Task getTask(int ind) {
        return tasks.get(ind);
    }

    public int getSize() {
        return tasks.size();
    }
}
