package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents command to search for a task by searching a keyword.
 */
public class FindCommand extends Command {
    /** Keyword entered by user. */
    protected String userIn;

    /**
     * Initializes a FindCommand object with keyword entered by user.
     * @param userIn keyword entered by user.
     */
    public FindCommand(String userIn) {
        this.userIn = userIn;
    }

    /**
     * Finds tasks that contain the keyword entered by user.
     * @param tasks TaskList representing a list of all tasks.
     * @param storage storage used for saving, loading and storing user data.
     * @return String to notify the user of the execution of this command.
     */
    public String execute(TaskList tasks, Storage storage) {
        List<Task> taskWithKey = tasks.getStream()
                .filter(t -> t.hasWord(userIn)).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the matching tasks in your list \n");
        int count = 1;
        for (Task t:taskWithKey) {
            sb.append(count + ": " + t + "\n");
            count++;
        }
        return sb.toString();
    }
}
