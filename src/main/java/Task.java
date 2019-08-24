public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public boolean getStatus() {
        return isDone;
    }

    public String getSaveData() {
        String status = isDone ? "1" : "0";
        return status + " \0 " + description;
    }
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
