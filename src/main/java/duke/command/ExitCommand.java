package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;

/**
 * Represents a command to exit the program.
 */
public class ExitCommand extends Command {
    private static final String MESSAGE_SUCCESS = "Bye. Hope to see you again soon!";

    /**
     * Saves the TaskList in the storage file and changes isExit to true to exit the program.
     * @param tasks TaskList object which represents the list of tasks created by the user.
     * @param storage storage which loads, saves and stores data of user.
     * @return String to notify the user of the execution of this command.
     * @throws DukeException if there is a saving error.
     */
    public String execute(TaskList tasks, Storage storage) throws DukeException {
        storage.saveAll(tasks);
        isExit = true;
        return MESSAGE_SUCCESS;
    }
}
