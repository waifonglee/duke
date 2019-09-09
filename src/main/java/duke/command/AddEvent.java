package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.tag.Tag;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;

import java.util.HashSet;

/**
 * Represents a command to add an event object to TaskList.
 */
public class AddEvent extends Command {
    /** Description of event entered by user. */
    protected String userIn;

    private static final String MESSAGE_SUCCESS = "Got it. I've added this task: \n"
            + "%s" + "\n" + "Now you have %d task(s) in the list.";

    private static final String MESSAGE_INVALID_INPUT = "Invalid description entered";

    /**
     * Initializes an Event object with the user input.
     * @param userIn description of event entered by user.
     */
    public AddEvent(String userIn) {
        this.userIn = userIn;
    }

    /**
     * Adds an event object into the list of tasks.
     * @param tasks TaskList object which represents the list of tasks created by the user.
     * @param storage storage which loads, saves and stores data of user.
     * @return String to notify the user of the execution of this command.
     * @throws DukeException if user input is invalid.
     */
    public String execute(TaskList tasks, Storage storage) throws DukeException {
        try {
            Task newEvent;
            String[] splitInput = userIn.split(" /at ");
            String desc = splitInput[0];
            String[] splitByTag = splitInput[1].split(" /tag ");
            boolean isTagged = splitByTag.length > 1;

            if (isTagged) {
                String by = splitByTag[0];
                String inputTags = splitByTag[1];
                HashSet<Tag> tags = Parser.parseTags(inputTags);
                newEvent = new Event(desc, by, tags);
            } else {
                String by = splitInput[1];
                newEvent = new Event(desc,by);
            }

            tasks.addTask(newEvent);
            int taskNum = tasks.getSize();
            return String.format(MESSAGE_SUCCESS, newEvent, taskNum);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException(MESSAGE_INVALID_INPUT);
        }
    }
}
