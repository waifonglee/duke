package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.*;

/**
 * Represents a command to delete a task in the list of tasks.
 */
public class DeleteCommand extends Command {
    /** Index of task user wants to delete. */
    String userIn;

    /**
     * Initializes a DeleteCommand with the user input
     * @param userIn index of task user wants to delete.
     */
    public DeleteCommand(String userIn) {
        this.userIn = userIn;
    }

    /**
     * Deletes a specified task requested by the user and then prints out the relevant message.
     * @param tasks TaskList object which represents the list of tasks created by the user.
     * @param storage storage which loads, saves and stores data of user.
     * @throws DukeException if index in user input is invalid.
     */
    public void execute(TaskList tasks, Storage storage) throws DukeException {
        try {
            int ind = Integer.parseInt(userIn) - 1;
            Task delTask = tasks.getTask(ind);
            tasks.deleteTask(ind);
            System.out.println("Noted. I've removed this task: \n" + delTask + "\nNow you have "
                    + tasks.getSize() + " task(s) in the list.");
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeException("Invalid task number entered");
        }
    }
}
