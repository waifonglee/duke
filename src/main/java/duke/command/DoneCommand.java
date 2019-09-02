package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;

/**
 * Represents a command to complete a task.
 */
public class DoneCommand extends Command {
    /** Index of task user has completed. */
    String userIn;

    /**
     * Initializes a DoneCommand with the user input.
     * @param userIn index of task user has completed.
     */
    public DoneCommand(String userIn) {
        this.userIn = userIn;
    }

    /**
     * Completes a specified task by marking it as done.
     * @param tasks TaskList object which represents the list of tasks created by the user.
     * @param storage storage which loads, saves and stores data of user.
     * @return String to notify the user of the execution of this command.
     * @throws DukeException if index in user input is invalid.
     */
    public String execute(TaskList tasks, Storage storage) throws DukeException {
        try {
            int ind = Integer.parseInt(userIn) - 1;
            Task currTask = tasks.getTask(ind);
            currTask.markAsDone();
            String response = "Nice! I've marked this task as done: \n" + currTask;
            return response;
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeException("Invalid task number entered");
        }
    }
}
