import duke.exception.DukeException;
import duke.task.Todo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void testToString() throws DukeException {
        assertEquals("[T][\u2718] do 2103 project",
                new Todo("do 2103 project").toString());
    }

    @Test
    public void testGetSaveData() throws DukeException {
        assertEquals("T \0 0 \0 test",
                new Todo("test").getSaveData());
    }
}