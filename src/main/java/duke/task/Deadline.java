package duke.task;

import duke.exception.DukeException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a Task which has a deadline to adhere to.
 */
public class Deadline extends Task {
    /** String which represents the deadline of the task. */
    protected String by;

    /** Date object which represents the deadline of the task. */
    protected Date dateBy;

    /** Formatter object to format the deadline correctly. */
    protected static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");

    /**
     * Initializes a Deadline Object with the description of the task and the deadline of the task.
     * This object is initialized as uncompleted.
     * @param description description of the task.
     * @param by deadline of the task.
     * @throws DukeException if description is empty or the deadline is of the wrong format.
     */
    public Deadline(String description, String by) throws DukeException {
        super(description);
        this.by = by;
        checkValidBy();
    }

    private void checkValidBy() throws DukeException {
        try {
            this.dateBy = formatter.parse(by);
            if (!formatter.format(dateBy).equals(by)) {
                throw new DukeException("Invalid date!");
            }
        } catch (ParseException e) {
            throw new DukeException("Invalid date format : dd/mm/yyyy HHmm");
        }
    }

    /**
     * Returns a string consisting of keywords that users can use to search for this
     * task.
     * @return String of keywords.
     */
    @Override
    public String getKeywords() {
        return description + " " + by;
    }

    /**
     * Returns a string representation to be used for saving data of this object.
     * @return String representation of this object for saving.
     */
    @Override
    public String getSaveData() {
        String status = isDone ? "1" : "0";
        return "D \0 " + super.getSaveData() + " \0 " + by;
    }

    /**
     * Returns a string representation of this object.
     * @return String representation of this object.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
