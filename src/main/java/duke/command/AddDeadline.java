package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.tag.Tag;
import duke.task.Deadline;
import duke.task.TaskList;
import duke.task.Task;

import java.util.HashSet;

/**
 * Represents a command to add a deadline object to TaskList.
 */
public class AddDeadline extends Command {
    /** Description and deadline of task entered by user.*/
    protected String userIn;

    private static final String MESSAGE_SUCCESS = "Got it. I've added this task: \n"
            + "%s" + "\n" + "Now you have %d task(s) in the list.";

    private static final String MESSAGE_INVALID_INPUT = "Invalid description entered";

    /**
     * Initializes an AddDeadline Object with the user input.
     * @param userIn description and deadline of task entered by user.
     */
    public AddDeadline(String userIn) {
        this.userIn = userIn;
    }

    /**
     * Adds a Deadline task object into the list of tasks.
     * @param tasks TaskList object which represents the list of tasks created by the user.
     * @param storage storage which loads, saves and stores data of user.
     * @return String to notify the user of the execution of this command.
     * @throws DukeException if user input is invalid.
     */
    public String execute(TaskList tasks, Storage storage) throws DukeException {
        try {
            Task newDl;
            String[] splitInput = userIn.split(" /by ");
            String desc = splitInput[0];
            String[] splitByTag = splitInput[1].split(" /tag ");
            boolean isTagged = splitByTag.length > 1;

            if (isTagged) {
                String by = splitByTag[0];
                String inputTags = splitByTag[1];
                HashSet<Tag> tags = Parser.parseTags(inputTags);
                newDl = new Deadline(desc, by, tags);
            } else {
                String by = splitInput[1];
                newDl = new Deadline(desc,by);
            }

            tasks.addTask(newDl);
            int taskNum = tasks.getSize();
            return String.format(MESSAGE_SUCCESS, newDl, taskNum);

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException(MESSAGE_INVALID_INPUT);
        }
    }
}
