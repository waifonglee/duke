package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.task.*;

public class AddDeadline extends Command {
    protected String userIn;

    public AddDeadline(String userIn) {
        this.userIn = userIn;
    }

    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
        try {
            String[] spUserIn = userIn.split(" /by ");
            Task newDl = new Deadline(spUserIn[0], spUserIn[1]);
            tasks.addTask(newDl);
            System.out.println("Got it. I've added this task: \n" + newDl + "\nNow you have "
                    + tasks.getSize() + " task(s) in the list.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Invalid description");
        }

    }
}
