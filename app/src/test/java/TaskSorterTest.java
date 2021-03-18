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


    private final ToDoList testToDoList = new ToDoList();
    private final TaskSorter testSorter= new TaskSorter(testToDoList);
    final Task task1 = new Task("Debug", "SDA", LocalDate.parse("2021-03-16"));
    final Task task2 = new Task( "Test", "Java", LocalDate.parse("2021-03-16"));
    final Task task3 = new Task("Debug again", "IP", LocalDate.parse("2021-12-22"));
    final Task task4  = new Task("Test more", "Java", LocalDate.parse("2021-12-31"));




    @BeforeEach
    public void setUp() {
        testToDoList.addTask(task1);
        testToDoList.addTask(task2);
        testToDoList.addTask(task3);
        testToDoList.addTask(task4);

    }
    @Test
    @DisplayName("Tasks are sorted by project")
    void TasksAreSortedByProject() {
       ToDoList testToDoList2= new ToDoList();
       testToDoList2.addTask(task3);
       testToDoList2.addTask(task2);
       testToDoList2.addTask(task4);
       testToDoList2.addTask(task1);
        testSorter.sortAllTasks("2");
    }

    @Test
    @DisplayName("Tasks are sorted by deadline")
    void TasksAreSortedByDeadline() {
        testToDoList.addTask(new Task("Debug again again", "IP", LocalDate.parse("2021-12-22")));
        testToDoList.addTask(new Task("Test again", "Java", LocalDate.parse("2021-12-31")));
        testToDoList.addTask(new Task("finish him", "IP", LocalDate.parse("2021-03-19")));
        testToDoList.addTask(new Task("empty project", "", LocalDate.parse("2021-03-20")));
        ToDoList testToDoList2 = new ToDoList();
        /*testToDoList2.getTask(2).addTask();
        testToDoList2.getTask(3).addTask();
        testToDoList2.getTask(0).addTask();
        testToDoList2.getTask(1).addTask();*/

        //assertEquals(testToDoList2,testSorter.sortAllTasks("2"));


        //testToDoList.asArray().stream().forEach(task -> System.out.println(

    }




}
