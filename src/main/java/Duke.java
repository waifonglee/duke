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
            String input = sc.nextLine();
            printOutput(input);
            if (input.equalsIgnoreCase("bye")) {
                break;
            }
        }
    }

    public static void printOutput(String input) {
        switch (input.toLowerCase().split(" ")[0]) {
            case "bye":
                System.out.println("Bye. Hope to see you again soon!");
                break;
            case "list":
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskList.size(); i++) {
                    System.out.println(i + 1 + ". " + taskList.get(i));
                }
                break;
            case "done":
                String[] splitBySpace = input.split(" ");
                Task current = taskList.get(Integer.parseInt(splitBySpace[1]) - 1);
                current.markAsDone();
                System.out.println("Nice! I've marked this task as done: \n" + current);
                break;
            case "todo":
            case "deadline":
            case "event":
                Task task = getTask(input);
                taskList.add(task);
                System.out.println("Got it. I've added this task: \n" + task + "\nNow you have "
                        + taskList.size() + " task(s) in the list.");
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public static Task getTask(String input) {
        String typeOfTask = input.split(" ")[0];
        String taskDes = input.split(typeOfTask)[1];
        Task newTask;
        switch (typeOfTask.toLowerCase()) {
            case "deadline":
                String[] splitDl = taskDes.split("/by");
                newTask = new Deadline(splitDl[0].trim(), splitDl[1].trim());
                break;
            case "event":
                String[] splitEv = taskDes.split("/at");
                newTask = new Event(splitEv[0].trim(), splitEv[1].trim());
                break;
            default:
                newTask = new Todo(taskDes.trim());
        }
        return newTask;
    }
}
