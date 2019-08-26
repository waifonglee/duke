package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.ui.Ui;
import duke.task.*;

public class AddTodo extends Command {
    protected String userIn;

    public AddTodo(String userIn) {
        this.userIn = userIn;
    }

    public void execute(TaskList tasks, Storage storage, Ui ui) throws DukeException {
        Task newTodo = new Todo(userIn);
        tasks.addTask(newTodo);
        System.out.println("Got it. I've added this task: \n" + newTodo + "\nNow you have "
                + tasks.getSize() + " task(s) in the list.");
    }
}
