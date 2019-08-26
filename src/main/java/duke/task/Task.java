package duke.task;

import duke.exception.DukeException;

public class Task {
    String description;
    protected boolean isDone;

    public Task(String description) throws DukeException {
        if (description.trim().isEmpty()) {
            throw new DukeException("Description shouldn't be empty!");
        }
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String getSaveData() {
        String status = isDone ? "1" : "0";
        return status + " \0 " + description;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
