import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    protected static ArrayList<Task> taskList = new ArrayList<Task>();

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String greet = "Hello! I'm Duke\n"
                + "What can I do for you?";
        System.out.println("Hello from\n" + logo + "\n" + greet);
        run();
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            try {
                String input = sc.nextLine();
                printOutput(input);
                if (input.equalsIgnoreCase("bye")) {
                    break;
                }
            } catch (DukeException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static void printOutput(String input) throws DukeException {
        switch (input.toLowerCase()) {
            case "bye":
                System.out.println("Bye. Hope to see you again soon!");
                break;
            case "list":
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskList.size(); i++) {
                    System.out.println(i + 1 + ". " + taskList.get(i));
                }
                break;
            default:
                String[] splitBySpace = input.split(" ");
                if (splitBySpace.length == 2 && splitBySpace[0].equalsIgnoreCase("done")) {
                    Task current = taskList.get(Integer.parseInt(splitBySpace[1]) - 1);
                    current.markAsDone();
                    System.out.println("Nice! I've marked this task as done: \n" + current);
                } else {
                    Task task = getTask(input);
                    taskList.add(task);
                    System.out.println("Got it. I've added this task: \n" + task + "\nNow you have "
                            + taskList.size() + " task(s) in the list.");
                }
        }
    }

    public static Task getTask(String input) throws DukeException {
        String typeOfTask = input.split(" ")[0];
        String[] descArr = input.split(typeOfTask);
        Task newTask;
        switch (typeOfTask.toLowerCase()) {
            case "deadline":
                if (descArr.length == 0 || descArr[1].trim().isEmpty()) {
                    throw new DukeException("☹ OOPS!!! The description of deadline cannot be empty.");
                }
                String[] splitDl = descArr[1].split("/by");
                if (splitDl.length < 2 || splitDl[0].trim().isEmpty() || splitDl[1].trim().isEmpty()) {
                    throw new DukeException("☹ OOPS!!! Wrong format of description.");
                }
                newTask = new Deadline(splitDl[0].trim(), splitDl[1].trim());
                break;
            case "event":
                if (descArr.length == 0 || descArr[1].trim().isEmpty()) {
                    throw new DukeException("☹ OOPS!!! The description of this event cannot be empty.");
                }
                String[] splitEv = descArr[1].split("/at");
                if (splitEv.length < 2 || splitEv[0].trim().isEmpty() || splitEv[1].trim().isEmpty()) {
                    throw new DukeException("☹ OOPS!!! Wrong format of description.");
                }
                newTask = new Event(splitEv[0].trim(), splitEv[1].trim());
                break;
            case "todo":
                if (descArr.length == 0 || descArr[1].trim().isEmpty()) {
                    throw new DukeException("☹ OOPS!!! The description of todo cannot be empty.");
                }
                newTask = new Todo(descArr[1].trim());
                break;
            default:
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
        return newTask;
    }
}
