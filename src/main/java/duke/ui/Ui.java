package duke.ui;

import java.util.Scanner;
import duke.exception.DukeException;

/**
 * Represents the Ui which deals with user interactions.
 */
public class Ui {
    /** Scanner object which scans user input. */
    private Scanner sc = new Scanner(System.in);

    /**
     * Prints out welcome message when user opens Duke.
     */
    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String greet = "Hello! I'm Duke\n"
                + "What can I do for you?";
        System.out.println("Hello from\n" + logo + "\n" + greet);
    }

    /**
     * Reads the command of the user.
     * @return command of user.
     * @throws DukeException if user input is empty.
     */
    public String readCommand() throws DukeException {
        String command = sc.nextLine();
        if (command.isEmpty()) {
            throw new DukeException("Command cannot be empty");
        }
        return command;
    }

    /**
     * Prints out error message.
     * @param message message of the exception caught.
     */
    public void showError(String message) {
        System.out.println(message);
    }
}
