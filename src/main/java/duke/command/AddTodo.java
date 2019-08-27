package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.Todo;

/**
 * Represents a command to add a Todo object to TaskList.
 */
public class AddTodo extends Command {
    /** Description of task entered by user.*/
    protected String userIn;

    /**
     * Initializes an AddTodo Object with the user input.
     * @param userIn description of task entered by user.
     */
    public AddTodo(String userIn) {
        this.userIn = userIn;
    }

    /**
     * Adds a Todo task object into the list of tasks and prints out a message to
     * inform the user of such.
     * @param tasks TaskList object which represents the list of tasks created by the user.
     * @param storage storage which loads, saves and stores data of user.
     * @throws DukeException if user input is invalid.
     */
    public void execute(TaskList tasks, Storage storage) throws DukeException {
        Task newTodo = new Todo(userIn);
        tasks.addTask(newTodo);
        System.out.println("Got it. I've added this task: \n" + newTodo + "\nNow you have "
                + tasks.getSize() + " task(s) in the list.");
    }
}
