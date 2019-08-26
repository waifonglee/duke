package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.task.*;

public class DoneCommand extends Command {
    String userIn;

    public DoneCommand(String userIn) {
        this.userIn = userIn;
    }

    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
        try {
            int ind = Integer.parseInt(userIn) - 1;
            Task currTask = tasks.getTask(ind);
            currTask.markAsDone();
            System.out.println("Nice! I've marked this task as done: \n" + currTask);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeException("Invalid task number entered");
        }
    }
}
