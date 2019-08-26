package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.*;

/**
 * Represents a command to add a deadline object to TaskList.
 */
public class AddEvent extends Command {
    protected String userIn;

    public AddEvent(String userIn) {
        this.userIn = userIn;
    }

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
