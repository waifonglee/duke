public class DoneCommand extends Command {
    public DoneCommand(String userIn) {
        super(userIn);
    }

    public void execute(TaskList tasks, Storage storage, Ui ui) {
        System.out.println("Bye. Hope to see you again soon!");
        storage.saveAll(tasks);
        this.isExit = true;
    }
}
