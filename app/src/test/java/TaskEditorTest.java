import main.java.BeeOrderly.Task;
import main.java.BeeOrderly.ToDoList;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class TaskEditorTest {

    private final ToDoList testToDoList = new ToDoList();

    @BeforeEach
    public void setUp() {
        testToDoList.addTask(new Task("Debug", "SDA", LocalDate.parse("2021-03-16")));
        testToDoList.addTask(new Task("Test", "Java", LocalDate.parse("2021-03-16")));
        testToDoList.addTask(new Task("Debug again", "IP", LocalDate.parse("2021-12-22")));
        testToDoList.addTask(new Task("Test more", "Java", LocalDate.parse("2021-12-31")));
        testToDoList.addTask(new Task("Debug again again", "IP", LocalDate.parse("2021-12-22")));
        testToDoList.addTask(new Task("Test again", "Java", LocalDate.parse("2021-12-31")));
        testToDoList.addTask(new Task("finish him", "IP", LocalDate.parse("2021-03-19")));
        testToDoList.addTask(new Task("finish him", "", LocalDate.parse("2021-03-19")));
    }
}
