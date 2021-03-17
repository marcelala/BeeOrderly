import java.time.LocalDate;
import main.java.BeeOrderly.ToDoList;
import main.java.BeeOrderly.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoListTest {

    private final ToDoList testToDoList = new ToDoList();
    //Set up a ToDoList and create three tasks.
    @BeforeEach
    public void setUp() {
        testToDoList.addTask(new Task("Debug", "SDA", LocalDate.parse("2021-12-30")));
        testToDoList.addTask(new Task("Test", "Java", LocalDate.parse("2021-12-31")));
        testToDoList.addTask(new Task("Debug again", "IP", LocalDate.parse("2021-12-22")));
    }
    //get this test to work
    @Test
    @DisplayName("Create a new task with name, project and deadline")
    void createNewTaskWithNameProjectAndDeadline() {
        String name = "sleep";
        String project = "survive";
        LocalDate deadline = LocalDate.parse("2021-03-19");
        //testToDoList.createTask();
        //assertTrue(testToDoList.createTask());

    }
}
