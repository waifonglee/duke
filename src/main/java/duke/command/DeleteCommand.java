package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.task.*;

public class DeleteCommand extends Command {
    String userIn;

    public DeleteCommand(String userIn) {
        this.userIn = userIn;
    }

    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
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
