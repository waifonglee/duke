package duke.command;

import duke.storage.Storage;
import duke.tag.Tag;
import duke.task.Task;
import duke.task.TaskList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a command to list out all the tasks tagged with a specific tag.
 */
public class FindTagCommand extends Command {
    /** Tag name entered by user. */
    protected String userIn;

    /** Tag object. */
    protected Tag tag;

    /**
     * Initializes a FindTagCommand object with tag name entered by user.
     * @param userIn tag name entered by user.
     */
    public FindTagCommand(String userIn) {
        this.userIn = userIn;
        tag = new Tag(userIn);
    }

    /**
     * Finds tasks that are tagged with the specific tag.
     * @param tasks TaskList representing a list of all tasks.
     * @param storage storage used for saving, loading and storing user data.
     * @return String to notify the user of the execution of this command.
     */
    public String execute(TaskList tasks, Storage storage) {
        List<Task> sameTagTasks = tasks.getStream().filter(task -> task.hasTag(tag))
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the tasks under " + userIn + ":\n");
        int count = 1;
        for (Task t : sameTagTasks) {
            sb.append(count + ": " + t + "\n");
            count++;
        }
        return sb.toString();
    }

}
