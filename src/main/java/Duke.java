import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        try {
            run();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void run() throws IOException {
        File savedData = new File("data.txt");
        boolean shouldCreate = savedData.createNewFile();
        if (!shouldCreate) {
            loadData(savedData);
        }
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            try {
                String input = sc.nextLine();
                printOutput(input, savedData);
                if (input.equalsIgnoreCase("bye")) {
                    break;
                }
            } catch (DukeException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static void loadData(File f) throws FileNotFoundException {
        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            String data = s.nextLine();
            String[] splitData = data.split("\0");
            if (splitData[0].trim().equals("T")) {
                Task t = new Todo(splitData[2].trim());
                if (splitData[1].trim().equals("1")) {
                    t.markAsDone();
                }
                taskList.add(t);
            } else if (splitData[0].trim().equals("D")) {
                Task t = new Deadline(splitData[2].trim(), splitData[3].trim());
                if (splitData[1].trim().equals("1")) {
                    t.markAsDone();
                }
                taskList.add(t);
            } else {
                Task t = new Event(splitData[2].trim(), splitData[3].trim());
                if (splitData[1].trim().equals("1")) {
                    t.markAsDone();
                }
                taskList.add(t);
            }
        }
    }

    public static void saveNewTask(File f, Task task) throws IOException {
        FileWriter fw = new FileWriter(f, true);
        fw.write(task.getSaveData() + "\n");
        fw.close();
    }

    public static void saveAlterTask(File f, int ind, boolean shouldDel) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner s = new Scanner(f);
        int lineNum = 0;
        while (s.hasNextLine()) {
            String nextData = s.nextLine();
            if (lineNum != ind) {
                sb.append(nextData + "\n");
            } else {
                if (shouldDel) {
                    continue;
                } else {
                    sb.append(taskList.get(ind).getSaveData() + "\n");
                }
            }
            lineNum++;
        }
        FileWriter fw = new FileWriter(f);
        fw.write(sb.toString());
        fw.close();
    }

    public static void printOutput(String input, File f) throws DukeException, IOException {
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
                int ind = Integer.parseInt(splitBySpace[1]) - 1;
                Task currTask = taskList.get(ind);
                currTask.markAsDone();
                saveAlterTask(f, ind, false);
                System.out.println("Nice! I've marked this task as done: \n" + currTask);
                break;
            }

            if (splitBySpace.length == 2 && splitBySpace[0].equalsIgnoreCase("delete")) {
                int indToDel = Integer.parseInt(splitBySpace[1]) - 1;
                Task taskToDel = taskList.get(indToDel);
                taskList.remove(indToDel);
                saveAlterTask(f, indToDel, true);
                System.out.println("Noted. I've removed this task: \n" + taskToDel + "\nNow you have "
                        + taskList.size() + " task(s) in the list.");
                break;
            }

            Task task = getTask(input);
            taskList.add(task);
            saveNewTask(f, task);
            System.out.println("Got it. I've added this task: \n" + task + "\nNow you have "
                    + taskList.size() + " task(s) in the list.");

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
                throw new DukeException("☹ OOPS!!! The description of event cannot be empty.");
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
