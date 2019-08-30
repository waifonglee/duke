package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;

/**
 * Represents a command to exit the program.
 */
public class ExitCommand extends Command {
    /**
     * Saves the TaskList in the storage file and changes isExit to true to exit the program.
     * A relevant message will be printed.
     * @param tasks TaskList object which represents the list of tasks created by the user.
     * @param storage storage which loads, saves and stores data of user.
     * @throws DukeException if there is a saving error.
     */
    public void execute(TaskList tasks, Storage storage) throws DukeException {
        System.out.println("Bye. Hope to see you again soon!");
        storage.saveAll(tasks);
        isExit = true;
    }
}
