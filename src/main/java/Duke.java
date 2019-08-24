import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    protected static ArrayList<Task> taskList = new ArrayList<Task>();
    protected static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HHmm");

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
            } catch (ParseException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void printOutput(String input) throws DukeException, ParseException {
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
                    Task currTask = taskList.get(Integer.parseInt(splitBySpace[1]) - 1);
                    currTask.markAsDone();
                    System.out.println("Nice! I've marked this task as done: \n" + currTask);
                    break;
                }

                if (splitBySpace.length == 2 && splitBySpace[0].equalsIgnoreCase("delete")) {
                    int indToDel = Integer.parseInt(splitBySpace[1]) - 1;
                    Task taskToDel = taskList.get(indToDel);
                    taskList.remove(indToDel);
                    System.out.println("Noted. I've removed this task: \n" + taskToDel + "\nNow you have "
                            + taskList.size() + " task(s) in the list.");
                    break;
                }

                Task task = getTask(input);
                taskList.add(task);
                System.out.println("Got it. I've added this task: \n" + task + "\nNow you have "
                        + taskList.size() + " task(s) in the list.");

        }
    }

    public static Task getTask(String input) throws DukeException, ParseException {
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
                if (!splitDl[1].trim().matches("\\d{2}\\/\\d{2}\\/\\d{4}\\s\\d{4}")) {
                    throw new DukeException("☹ OOPS!!! Wrong date format, only write in dd/mm/yy HHmm");
                }
                newTask = new Deadline(splitDl[0].trim(), splitDl[1].trim(), dateFormatter);
                break;
            case "event":
                if (descArr.length == 0 || descArr[1].trim().isEmpty()) {
                    throw new DukeException("☹ OOPS!!! The description of event cannot be empty.");
                }
                String[] splitEv = descArr[1].split("/at");
                if (splitEv.length < 2 || splitEv[0].trim().isEmpty() || splitEv[1].trim().isEmpty()) {
                    throw new DukeException("☹ OOPS!!! Wrong format of description.");
                }
                if (!splitEv[1].trim().matches("\\d{2}\\/\\d{2}\\/\\d{4}\\s\\d{4}")) {
                    throw new DukeException("☹ OOPS!!! Wrong date format, only write in dd/mm/yy HHmm");
                }
                newTask = new Event(splitEv[0].trim(), splitEv[1].trim(), dateFormatter);
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
