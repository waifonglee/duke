package duke.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import duke.exception.DukeException;
import duke.task.*;
import duke.parser.Parser;

public class Storage {
    protected String filePath;
    protected File dataFile;

    public Storage(String filePath) {
        this.filePath = filePath;
        this.dataFile = new File(filePath);
    }

    public ArrayList<Task> load() throws DukeException {
        try {
            boolean shouldCreate = dataFile.createNewFile();
            if (shouldCreate) {
                throw new DukeException("No previously saved data");
            }
            ArrayList<Task> tasks = new ArrayList<Task>();
            Scanner sc = new Scanner(dataFile);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                Parser.parseLoad(data, tasks);
            }
            return tasks;
        } catch (IOException e) {
            throw new DukeException("Error loading");
        }
    }

    public void saveAll(TaskList tasks) throws DukeException {
        try {
            FileWriter fw = new FileWriter(dataFile);
            for (int i = 0; i < tasks.getSize(); i++) {
                Task currTask = tasks.getTask(i);
                fw.write(currTask.getSaveData() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            throw new DukeException("Error saving");
        }
    }
}
