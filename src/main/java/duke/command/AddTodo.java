package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.tag.Tag;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.Todo;

import java.util.HashSet;

/**
 * Represents a command to add a Todo object to TaskList.
 */
public class AddTodo extends Command {
    /** Description of task entered by user.*/
    protected String userIn;

    private static final String MESSAGE_SUCCESS = "Got it. I've added this task: \n"
            + "%s" + "\n" + "Now you have %d task(s) in the list.";

    private static final String MESSAGE_INVALID_INPUT = "Invalid description entered";

    /**
     * Initializes an AddTodo Object with the user input.
     *
     * @param userIn description of task entered by user.
     */
    public AddTodo(String userIn) {
        this.userIn = userIn;
    }

    /**
     * Adds a Todo task object into the list of tasks.
     *
     * @param tasks TaskList object which represents the list of tasks created by the user.
     * @param storage storage which loads, saves and stores data of user.
     * @return String to notify the user of the execution of this command.
     * @throws DukeException if user input is invalid.
     */
    public String execute(TaskList tasks, Storage storage) throws DukeException {
        Task newTodo;
        String[] splitByTag = userIn.split(" /tag ");
        String desc = splitByTag[0];
        boolean isTagged = splitByTag.length > 1;

        if (isTagged) {
            String inputTags = splitByTag[1];
            HashSet<Tag> tags = Parser.parseTags(inputTags);
            newTodo = new Todo(desc, tags);
        } else {
            newTodo = new Todo(desc);
        }

        tasks.addTask(newTodo);
        int taskNum = tasks.getSize();
        return String.format(MESSAGE_SUCCESS, newTodo, taskNum);
    }
}
