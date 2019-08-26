package duke.ui;

import java.util.Scanner;
import duke.exception.DukeException;

public class Ui {
    private Scanner sc = new Scanner(System.in);;

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

    public String readCommand() throws DukeException {
        String command = sc.nextLine();
        if (command.isEmpty()) {
            throw new DukeException("Command cannot be empty");
        }
        return command;
    }

    public void showError(String message) {
        System.out.println(message);
    }

}
