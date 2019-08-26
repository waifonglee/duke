package duke.task;

import duke.exception.DukeException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    protected String by;
    protected Date dateBy;
    protected static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");

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

    @Override
    public String getSaveData() {
        String status = isDone ? "1" : "0";
        return "D \0 " + super.getSaveData() + " \0 " + by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
