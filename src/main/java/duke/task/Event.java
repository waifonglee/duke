package duke.task;

import duke.exception.DukeException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {
    protected String at;
    protected Date dateAt;
    protected static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");

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

    @Override
    public String getSaveData() {
        String status = isDone ? "1" : "0";
        return "D \0 " + super.getSaveData() + " \0 " + at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
