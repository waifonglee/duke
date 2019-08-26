package duke.parser;

import duke.exception.DukeException;
import duke.task.*;
import duke.command.*;
import java.util.ArrayList;

public class Parser {
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
                    default:
                        throw new DukeException("Invalid Input!");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Invalid description");
        }
    }

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
            Task t = new Event(splitData[2], splitData[3]);
            if (splitData[1].equals("1")) {
                t.markAsDone();
            }
            tasks.add(t);
        }
    }


}
