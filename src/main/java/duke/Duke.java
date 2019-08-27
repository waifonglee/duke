import duke.command.Command;
import duke.ui.Ui;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.parser.Parser;
import duke.exception.DukeException;

/**
 * Represents a bot which tracks user's tasks.
 */
public class Duke {
    /** Storage to load, save and store user data. */
    private Storage storage;

    /** TaskList to store all the tasks. */
    private TaskList tasks;

    /** Ui to deal with user interaction. */
    private Ui ui;

    /**
     * Initializes a Duke object with the specified file path to create a storage path.
     * Previously saved data will be loaded and converted into a list of tasks
     * if there was one. Otherwise, an empty list will be initialized.
     * @param filePath file path for storage file.
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showError(e.getMessage());
            tasks = new TaskList();
        }
    }

    /**
     * Runs Duke by reading user input until user exits the program.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parseCommand(fullCommand);
                c.execute(tasks, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Duke("data.txt").run();
    }
}
