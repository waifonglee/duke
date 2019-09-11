package duke.command;

import duke.storage.Storage;
import duke.tag.Tag;
import duke.task.Task;
import duke.task.TaskList;

import java.util.List;
import java.util.stream.Collectors;

public class FindTagCommand extends Command {
    protected String userIn;
    protected Tag tag;

    public FindTagCommand(String userIn) {
        this.userIn = userIn;
        tag = new Tag(userIn);
    }

    public String execute(TaskList tasks, Storage storage) {
        List<Task> sameTagTasks = tasks.getStream().filter(task -> task.hasTag(tag))
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the tasks under " + userIn + "\n");
        int count = 1;
        for (Task t : sameTagTasks) {
            sb.append(count + ": " + t + "\n");
            count++;
        }
        return sb.toString();
    }

}
