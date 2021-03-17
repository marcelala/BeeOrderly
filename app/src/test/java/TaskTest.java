
import java.time.LocalDate;
import main.java.BeeOrderly.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.UUID;



import static org.junit.jupiter.api.Assertions.*;


public class TaskTest {

    private Task testTask;

    @BeforeEach
    void setUp() {
        testTask = new Task("Test name","Test project", LocalDate.parse("2021-12-31"));}

    @Test
    @DisplayName("declare a new task with name, project and deadline")
    void declareNewTaskWithNameProjectAndDeadline() {
        assertEquals("Test name", testTask.getName());
        assertEquals("Test project", testTask.getProject());
        assertEquals(LocalDate.parse("2021-12-31"), testTask.getDeadline());
        assertFalse(testTask.isDone());
    }

    @Test
    @DisplayName("Get project should return null if empty")
    void getProjectShouldReturnNullIfEmpty() {
        Task taskWithoutProject = new Task("Test task",null, LocalDate.parse("2021-12-31"));
        assertNull(taskWithoutProject.getProject());
    }
    @Test
    @DisplayName("Set name should rename task")
    void setNameShouldRenameTask(){
        testTask.setName("testTask2");
        assertEquals ("testTask2",testTask.getName());
    }
    @Test
    @DisplayName("Set deadline should update task's deadline")
    void setDeadlineShouldUpdateTask(){
        testTask.setDeadline(LocalDate.parse("2021-11-11"));
        assertEquals (LocalDate.parse("2021-11-11"),testTask.getDeadline());
    }

    @Test
    @DisplayName("Set project should rename task's project")
    void setProjectShouldRenameTasksProject() {
        testTask.setProject("testTask2");
        assertEquals("testTask2", testTask.getProject());
    }
    @Test
    @DisplayName("Set task is done should update task's status")
    void setTaskIsDoneShouldUpdateTasksStatus() {
        testTask.setDone();
        assertTrue(testTask.setDone());
    }

    @Test
    @DisplayName("Get task UUID")
    void getTaskUUID() {
        testTask = new Task("Test uuid", "uuid project", LocalDate.parse("2021-12-31"));
        assertEquals(testTask.getUuid().toString(), testTask.getStringUUID(testTask));
    }


}
