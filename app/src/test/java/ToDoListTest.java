import java.time.LocalDate;
import java.util.UUID;

import main.java.BeeOrderly.model.ToDoList;
import main.java.BeeOrderly.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoListTest {

    private final ToDoList testToDoList = new ToDoList();
    private UUID uuid;
    //Set up a ToDoList and create three tasks.
    @BeforeEach
    public void setUp() {
        testToDoList.addTask(new Task("Debug", "SDA", LocalDate.parse("2021-12-30")));
        testToDoList.addTask(new Task("Test", "Java", LocalDate.parse("2021-12-31")));
        testToDoList.addTask(new Task("Debug again", "IP", LocalDate.parse("2021-12-22")));
    }
    //get this test to work
    @Test
    @DisplayName("Add task to task list")
    void addTaskToTaskListTest() {
        String name = "sleep";
        String project = "survive";
        LocalDate deadline = LocalDate.parse("2021-03-19");
        Task testTask = new Task(name, project,deadline);
        testToDoList.addTask(testTask);
        assertEquals(4,testToDoList.size());
    }
    @Test
    @DisplayName("Gets task by UUID")
    void getsTaskByUUID() {
        String name = "sleep";
        String project = "survive";
        LocalDate deadline = LocalDate.parse("2021-03-19");
        Task testTask = new Task(name, project,deadline);
        testToDoList.addTask(testTask);
        assertEquals(testTask,testToDoList.getTaskByUUID(testTask.getUuid()));
    }



}
