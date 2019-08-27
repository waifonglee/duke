package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;

/**
 * Represents a command to add an event object to TaskList.
 */
public class AddEvent extends Command {
    /** Description of event entered by user. */
    protected String userIn;

    /**
     * Initializes an Event object with the user input.
     * @param userIn description of event entered by user.
     */
    public AddEvent(String userIn) {
        this.userIn = userIn;
    }

    /**
     * Adds an event object into the list of tasks and prints out a message to inform the user
     * of such.
     * @param tasks TaskList object which represents the list of tasks created by the user.
     * @param storage storage which loads, saves and stores data of user.
     * @throws DukeException if user input is invalid
     */
    public void execute(TaskList tasks, Storage storage) throws DukeException {
        try {
            String[] splitUserIn = userIn.split(" /at ");
            Task newEvent = new Event(splitUserIn[0], splitUserIn[1]);
            tasks.addTask(newEvent);
            System.out.println("Got it. I've added this task: \n" + newEvent + "\nNow you have "
                    + tasks.getSize() + " task(s) in the list.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Invalid description");
        }
    }
}
