package duke.task;

import duke.exception.DukeException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents an Event.
 */
public class Event extends Task {
    /** String which represents the date and time of the event. */
    protected String at;

    /** Date object which represents the date and time of the event. */
    protected Date dateAt;

    /** Formatter object to format the date and time correctly. */
    protected static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");

    /**
     * Initializes an Event Object with the description of the event and its date
     * and time.
     * This object is initialized as uncompleted.
     * @param description description of the event.
     * @param at date and time of the event.
     * @throws DukeException if description is empty or the date and time is of the wrong format.
     */
    public Event(String description, String at) throws DukeException {
        super(description);
        this.at = at;
        checkValidAt();
    }

    private void checkValidAt() throws DukeException {
        try {
            this.dateAt = formatter.parse(at);
            if (!formatter.format(dateAt).equals(at)) {
                throw new DukeException("Invalid date!");
            }
        } catch (ParseException e) {
            throw new DukeException("Invalid date format : dd/mm/yyyy HHmm");
        }
    }

    /**
     * Returns a string consisting of keywords that users can use to search for this
     * event.
     * @return String of keywords.
     */
    @Override
    public String getKeywords() {
        return description + " " + at;
    }

    /**
     * Returns a string representation to be used for saving data of this object.
     * @return String representation of this object for saving.
     */
    @Override
    public String getSaveData() {
        String status = isDone ? "1" : "0";
        return "D \0 " + super.getSaveData() + " \0 " + at;
    }

    /**
     * Returns a string representation of this object.
     * @return String representation of this object.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
