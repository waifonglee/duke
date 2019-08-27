package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;

/**
 * Represents a command entered by the user.
 */
public abstract class Command {
    /** Represents whether user wants to exit the program. */
    protected boolean isExit = false;

    /**
     * Returns whether the user wants to exit the program.
     * @return whether user wants to exit the program.
     */
    public boolean isExit() {
        return isExit;
    }

    /**
     * Executes the command accordingly and make changes to the TaskList of tasks and
     * the storage.
     * @param tasks TaskList object which represents the list of tasks created by the user.
     * @param storage storage which loads, saves and stores data of user.
     * @throws DukeException if user input is invalid.
     */
    public abstract void execute(TaskList tasks, Storage storage) throws DukeException;

}
