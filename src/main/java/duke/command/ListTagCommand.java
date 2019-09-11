package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;

/**
 * Represents a command to list out all the tags created by the user.
 */
public class ListTagCommand extends Command {
    private static final String MESSAGE_LIST_TAG = "Here are all the tags: \n";

    /**
     * Lists out the tags created by the user.
     * @param tasks TaskList object which represents the list of tasks created by the user.
     * @param storage storage which loads, saves and stores data of user.
     * @return String to notify the user of the execution of this command.
     */
    public String execute(TaskList tasks, Storage storage) {
        String listTags = tasks.getAllTags();
        return MESSAGE_LIST_TAG + listTags;
    }
}
