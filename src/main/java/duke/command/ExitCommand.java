package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.task.TaskList;

public class ExitCommand extends Command {
    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
        System.out.println("Bye. Hope to see you again soon!");
        storage.saveAll(tasks);
        this.isExit = true;
    }
}
