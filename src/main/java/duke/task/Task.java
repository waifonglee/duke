package duke.task;

import duke.exception.DukeException;

/**
 * Represents a task.
 */
public class Task {
    /** String which represents the description of the task. */
    protected String description;

    /** Boolean which represents whether the task is completed. */
    protected boolean isDone;

    /**
     * Initializes a Task Object with the description of the task.
     * Task Object initializes as uncompleted.
     * @param description description of the task.
     * @throws DukeException if description is empty or just white spaces.
     */
    public Task(String description) throws DukeException {
        if (description.trim().isEmpty()) {
            throw new DukeException("Description shouldn't be empty!");
        }
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns a status icon to represent whether this task is completed.
     * @return Status icon to represent whether this task is completed.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Completes this task.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Returns a string representation to be used for saving data of this object.
     * @return String representation of this object for saving.
     */
    public String getSaveData() {
        String status = isDone ? "1" : "0";
        return status + " \0 " + description;
    }

    /**
     * Returns a string representation of this object.
     * @return String representation of this object.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
