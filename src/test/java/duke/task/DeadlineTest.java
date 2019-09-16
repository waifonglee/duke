package duke.task;

import duke.exception.DukeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    public void testToString() throws DukeException {
        assertEquals("[D][\u2718] do 2103 project (by: Sat Sep 14 23:59:00 SGT 2019)",
                new Deadline("do 2103 project", "14/09/2019 2359").toString());
    }

    @Test
    public void testGetSaveData() throws DukeException {
        assertEquals("D \0 0 \0 test \0 26/08/2019 1400",
                new Deadline("test", "26/08/2019 1400").getSaveData());
    }
}
