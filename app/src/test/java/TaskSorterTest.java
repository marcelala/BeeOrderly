import main.java.BeeOrderly.model.Task;
import main.java.BeeOrderly.tools.TaskSorter;
import main.java.BeeOrderly.model.ToDoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskSorterTest {


    private final ArrayList<Task> testArrayList = new ArrayList<>();
    final Task task1 = new Task("Debug", "SDA", LocalDate.parse("2021-03-16"));
    final Task task2 = new Task( "Test", "Java", LocalDate.parse("2021-04-16"));
    final Task task3 = new Task("Debug again", "IP", LocalDate.parse("2021-12-22"));
    final Task task4  = new Task("Test more", "Java", LocalDate.parse("2021-12-31"));


    @BeforeEach
    public void setUp() {
    }
    @Test
    @DisplayName("Tasks are sorted by project")
    void TasksAreSortedByProject() {
        ToDoList toDoList = new ToDoList();
        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
        toDoList.addTask(task4);
        TaskSorter testSorter= new TaskSorter(toDoList);

        ArrayList<Task> sortedToDoList = testSorter.sortAllTasks("2");
        assertEquals(sortedToDoList.get(0), task3);
        assertEquals(sortedToDoList.get(1), task2);
        assertEquals(sortedToDoList.get(2), task4);
        assertEquals(sortedToDoList.get(3), task1);

    }

    @Test
    @DisplayName("Tasks are sorted by deadline")
    void TasksAreSortedByDeadline() {
        ToDoList toDoList = new ToDoList();
        toDoList.addTask(task2);
        toDoList.addTask(task4);
        toDoList.addTask(task1);
        toDoList.addTask(task3);
        TaskSorter testSorter= new TaskSorter(toDoList);

        ArrayList<Task> sortedToDoList = testSorter.sortAllTasks("1");
        assertEquals(sortedToDoList.get(0), task1);
        assertEquals(sortedToDoList.get(1), task2);
        assertEquals(sortedToDoList.get(2), task3);
        assertEquals(sortedToDoList.get(3), task4);

    }
}
