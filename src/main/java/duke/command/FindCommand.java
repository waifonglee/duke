package duke.command;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

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
     * Finds tasks that contain the keyword entered by user and print the relevant
     * message.
     * @param tasks TaskList representing a list of all tasks.
     * @param storage storage used for saving, loading and storing user data.
     */
    public void execute(TaskList tasks, Storage storage, Ui ui) {
        System.out.println("Here are the matching tasks in your list");
        int count = 1;
        for (int i = 0; i < tasks.getSize(); i++) {
            Task currTask = tasks.getTask(i);
            String[] splitString = currTask.toString().split(" ");
            for (int j = 0; j < splitString.length; j++) {
                if (splitString[j].equalsIgnoreCase(userIn)) {
                    System.out.println(count + ". " + currTask);
                    count++;
                }
            }
        }
    }
}
