package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.task.*;

public class AddEvent extends Command {
    protected String userIn;

    public AddEvent(String userIn) {
        this.userIn = userIn;
    }

    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
        try {
            String[] spUserIn = userIn.split(" /at ");
            Task newEvent = new Event(spUserIn[0], spUserIn[1]);
            tasks.addTask(newEvent);
            System.out.println("Got it. I've added this task: \n" + newEvent + "\nNow you have "
                    + tasks.getSize() + " task(s) in the list.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Invalid description");
        }
    }
}
