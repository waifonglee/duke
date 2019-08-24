import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    protected String by;
    protected Date dateBy;

    public Deadline(String description, String by, SimpleDateFormat f) throws ParseException {
        super(description);
        this.by = by;
        this.dateBy = f.parse(by);
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
