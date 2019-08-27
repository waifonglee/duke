package duke.task;

import java.util.ArrayList;

/**
 * Represents a list of every task created by the user.
 */
public class TaskList {
    /** ArrayList of tasks created by the user in this TaskList.*/
    private ArrayList<Task> tasks;

    /**
     * Initializes a TaskList object with the specified list of tasks.
     * @param tasks an existing list of tasks which will be initialized with the TaskList object.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Initializes a TaskList object with an empty list.
     */
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    /**
     * Adds a specified task to the list.
     * @param task task to be added to the list.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a specified task from the list.
     * @param ind index of the task to be deleted from the list.
     */
    public void deleteTask(int ind) {
        tasks.remove(ind);
    }

    /**
     * Returns a specified task.
     * @param ind index of the task to be returned.
     * @return Specified task.
     */
    public Task getTask(int ind) {
        return tasks.get(ind);
    }

    /**
     * Returns the size of the list.
     * @return Size of the list.
     */
    public int getSize() {
        return tasks.size();
    }
}
