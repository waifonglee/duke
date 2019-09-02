package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;

/**
 * Represents a command to list out all the tasks created by the user.
 */
public class ListCommand extends Command {
    /**
     * Lists out the tasks created by the user.
     * @param tasks TaskList object which represents the list of tasks created by the user.
     * @param storage storage which loads, saves and stores data of user.
     * @return String to notify the user of the execution of this command.
     */
    public String execute(TaskList tasks, Storage storage) {
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the tasks in your list: \n");
        for (int i = 0; i < tasks.getSize(); i++) {
            sb.append(i + 1 + ". " + tasks.getTask(i) + "\n");
        }
        return sb.toString();
    }
}
