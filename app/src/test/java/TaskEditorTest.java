import main.java.BeeOrderly.model.Task;
import main.java.BeeOrderly.model.ToDoList;
import main.java.BeeOrderly.tools.TaskEditor;
import main.java.BeeOrderly.tools.UserInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskEditorTest {

    private final ToDoList toDoList = new ToDoList();
    private final ArrayList<Task> testArrayList = new ArrayList<>();
    final Task task1 = new Task("Debug", "SDA", LocalDate.parse("2021-03-16"));
    final Task task2 = new Task( "Test", "Java", LocalDate.parse("2021-04-16"));
    final Task task3 = new Task("Debug again", "IP", LocalDate.parse("2021-12-22"));
    final Task task4  = new Task("Test more", "Java", LocalDate.parse("2021-12-31"));

    @BeforeEach
    public void setUp() {


        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
        toDoList.addTask(task4);

    }

    //@Test
    //@DisplayName("Task is renamed")
    // public void TaskIsRenamed() {
        //UserInput userInput ="editor test";
        //assertTrue(TaskEditor.renameTask(task1));


        //eq("editor test",task1.getName());
    }

/*
    @Test
    @DisplayName("Tasks' project is renamed"){}

    @Test
    @DisplayName("Tasks' deadline is updated"){}

    @Test
    @DisplayName("Task is deleted"){}

    @Test
    @DisplayName("Task status is updated"){}

    @Test
    @DisplayName("Tasks deadline is updated"){}

    @Test
    @DisplayName("Tasks status is not updated"){}



*/


//}
