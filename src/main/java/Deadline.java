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
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
