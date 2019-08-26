package duke.task;

import duke.exception.DukeException;

public class Todo extends Task {
    public Todo(String description) throws DukeException {
        super(description);
    }

    @Override
    public String getSaveData() {
        String status = isDone ? "1" : "0";
        return "T \0 " + super.getSaveData();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
