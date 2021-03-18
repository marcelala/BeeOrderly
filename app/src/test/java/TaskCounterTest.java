import main.java.BeeOrderly.model.Task;
import main.java.BeeOrderly.tools.TaskCounter;
import org.junit.jupiter.api.BeforeEach;
import main.java.BeeOrderly.model.ToDoList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class TaskCounterTest {
    private final ToDoList testToDoList = new ToDoList();
    private final TaskCounter testCounter = new TaskCounter(testToDoList);


    @BeforeEach
    public void setUp() {
        testToDoList.addTask(new Task("Debug", "SDA", LocalDate.parse("2021-03-16")));
        testToDoList.addTask(new Task("Test", "Java", LocalDate.parse("2021-03-16")));
        testToDoList.addTask(new Task("Debug again", "IP", LocalDate.parse("2021-12-22")));
        testToDoList.addTask(new Task("Test more", "Java", LocalDate.parse("2021-12-31")));
        testToDoList.addTask(new Task("Debug again again", "IP", LocalDate.parse("2021-12-22")));
        testToDoList.addTask(new Task("Test again", "Java", LocalDate.parse("2021-12-31")));
        testToDoList.addTask(new Task("finish him", "IP", LocalDate.parse("2021-03-19")));
        testToDoList.addTask(new Task("empty project", "", LocalDate.parse("2021-03-19")));
    }

    @Test
    @DisplayName("Completed Count is zero")
    void CompletedCountIsZero() {
        assertEquals(0,testCounter.completeCount());
    }
    @Test
    @DisplayName("Completed Count is three")
    void CompletedCountIsThree() {
        testToDoList.getTask(0).setDone();
        testToDoList.getTask(1).setDone();
        testToDoList.getTask(2).setDone();
        assertEquals(3,testCounter.completeCount());
    }
    @Test
    @DisplayName("Incomplete Count is five")
    void IncompleteCountIsFive() {
        testToDoList.getTask(0).setDone();
        testToDoList.getTask(1).setDone();
        testToDoList.getTask(2).setDone();
        assertEquals(5,testCounter.incompleteCount());
    }
    @Test
    @DisplayName("Incomplete Count is zero")
    void IncompleteCountIsZero() {
        testToDoList.getTask(0).setDone();
        testToDoList.getTask(1).setDone();
        testToDoList.getTask(2).setDone();
        testToDoList.getTask(3).setDone();
        testToDoList.getTask(4).setDone();
        testToDoList.getTask(5).setDone();
        testToDoList.getTask(6).setDone();
        testToDoList.getTask(7).setDone();
        assertEquals(0,testCounter.incompleteCount());
    }
    @Test
    @DisplayName("Overdue count is zero")
    void OverdueCountIsZero() {
        assertEquals(0,testCounter.overdueCount());
    }
    @Test
    @DisplayName("overdue Count is three")
    void OverdueCountIsThree() {
        testToDoList.addTask(new Task("Test again 3", "Java", LocalDate.parse("2011-12-31")));
        testToDoList.addTask(new Task("finish him2", "IP", LocalDate.parse("2000-03-19")));
        testToDoList.addTask(new Task("empty project0", "", LocalDate.parse("2020-03-19")));
        assertEquals(3, testCounter.overdueCount());
    }






}
