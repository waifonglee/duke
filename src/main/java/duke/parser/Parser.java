package duke.parser;

import duke.command.AddTodo;
import duke.command.Command;
import duke.command.DoneCommand;
import duke.command.DeleteCommand;
import duke.command.AddEvent;
import duke.command.ExitCommand;
import duke.command.AddDeadline;
import duke.command.FindCommand;
import duke.command.ListCommand;

import duke.exception.DukeException;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;

/**
 * Represents a Parser which is used to convert user input into the necessary objects.
 */
public class Parser {
    /**
     * Converts commands from user into the corresponding command objects to execute the commands.
     * @param command command from the user.
     * @return Command object created from the command from user.
     * @throws DukeException if command is invalid.
     */
    public static Command parseCommand(String command) throws DukeException {
        try {
            String[] splitString = command.split(" ", 2);
            if (splitString.length == 1) {
                switch (splitString[0].toLowerCase()) {
                case "list":
                    return new ListCommand();
                case "bye":
                    return new ExitCommand();
                default:
                    throw new DukeException("Invalid Input!");
                }
            } else {
                switch (splitString[0].toLowerCase()) {
                case "todo":
                    return new AddTodo(splitString[1]);
                case "deadline":
                    return new AddDeadline(splitString[1]);
                case "event":
                    return new AddEvent(splitString[1]);
                case "done":
                    return new DoneCommand(splitString[1]);
                case "delete":
                    return new DeleteCommand(splitString[1]);
                case "find":
                    return new FindCommand(splitString[1]);
                default:
                    throw new DukeException("Invalid Input!");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Invalid description");
        }
    }

    /**
     * Creates new Task objects depending on the saved data of the user
     * and adds it to the list of tasks. Completion of tasks are also checked
     * against the data and will be marked as done if the task is completed.
     * @param loadData saved data from the user to be loaded.
     * @param tasks ArrayList of tasks created from loading previously saved data.
     * @throws DukeException if description or time and date of tasks are invalid.
     */
    public static void parseLoad(String loadData, ArrayList<Task> tasks) throws DukeException {
        String[] splitData = loadData.split(" \0 ");
        if (splitData[0].equals("T")) {
            Task t = new Todo(splitData[2]);
            if (splitData[1].equals("1")) {
                t.markAsDone();
            }
            tasks.add(t);
        } else if (splitData[0].equals("D")) {
            Task t = new Deadline(splitData[2], splitData[3]);
            if (splitData[1].trim().equals("1")) {
                t.markAsDone();
            }
            tasks.add(t);
        } else {
            assert splitData[0].equals("E") : splitData[0];
            Task t = new Event(splitData[2], splitData[3]);
            if (splitData[1].equals("1")) {
                t.markAsDone();
            }
            tasks.add(t);
        }
    }


}
