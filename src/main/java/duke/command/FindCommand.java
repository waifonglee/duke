package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;

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
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the matching tasks in your list + \n");
        int count = 1;
        for (int i = 0; i < tasks.getSize(); i++) {
            Task currTask = tasks.getTask(i);
            String[] splitString = currTask.getKeywords().split(" ");
            for (String s : splitString) {
                if (s.equalsIgnoreCase(userIn)) {
                    sb.append(count + ". " + currTask + "\n");
                    count++;
                }
            }
        }
        return sb.toString();
    }
}
