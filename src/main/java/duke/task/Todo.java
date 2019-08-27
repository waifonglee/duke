package duke.task;

import duke.exception.DukeException;

/**
 * Represents a task to be done.
 */
public class Todo extends Task {
    /**
     * Initializes a Todo object with the description of the task.
     * This object is initialized as uncompleted.
     * @param description description of the task.
     * @throws DukeException if description is empty or just white spaces.
     */
    public Todo(String description) throws DukeException {
        super(description);
    }

    /**
     * Returns a string representation to be used for saving data of this object.
     * @return String representation of this object for saving.
     */
    @Override
    public String getSaveData() {
        String status = isDone ? "1" : "0";
        return "T \0 " + super.getSaveData();
    }

    /**
     * Returns a string representation of this object.
     * @return String representation of this object.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
