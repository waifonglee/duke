import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {
    protected String at;
    protected Date dateAt;

    public Event(String description, String at, SimpleDateFormat f) throws ParseException {
        super(description);
        this.at = at;
        this.dateAt = f.parse(at);
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
