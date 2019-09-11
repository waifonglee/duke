package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tag.Tag;
import duke.task.Task;
import duke.task.TaskList;

public class DeleteTagCommand extends Command {
    /** User input. */
    String userIn;

    public static final String MESSAGE_SUCCESS = "Tag has been deleted \n %s";

    public static final String MESSAGE_INVALID_FORMAT = "Invalid input: deltag (num) (tag)";

    public static final String MESSAGE_INVALID_NUM_TAG = "One tag only";

    /**
     * Initializes an instance of DeleteTagCommand with user input.
     * @param userIn user input.
     */
    public DeleteTagCommand(String userIn) {
        this.userIn = userIn;
    }

    /**
     * Deletes a tag from specified task by user
     * @param tasks TaskList object which represents the list of tasks created by the user.
     * @param storage storage which loads, saves and stores data of user.
     * @return String to notify the user of the execution of this command.
     * @throws DukeException if user input is invalid.
     */
    public String execute(TaskList tasks, Storage storage) throws DukeException {
        try {
            String[] getArgs = userIn.split(" ", 2);
            String ind = getArgs[0];
            boolean isOneWordTag = getArgs[1].split(" ").length == 1;

            if (isOneWordTag) {
                Tag tag = new Tag(getArgs[1]);
                int taskInd = Integer.parseInt(ind) - 1;
                Task t = tasks.getTask(taskInd);
                tasks.alterTaskTag(taskInd, tag, false);
                return String.format(MESSAGE_SUCCESS, t);
            } else {
                throw new DukeException(MESSAGE_INVALID_NUM_TAG);
            }

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeException(MESSAGE_INVALID_FORMAT);
        }
    }
}

