package main.java.BeeOrderly;


import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;


public class ToDoList implements Serializable {
    private final ArrayList<Task> taskList;

    public ToDoList(){
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }
    /**
     * Adds a Task object in ArrayList
     */
    public void createTask() {

        try {
            System.out.println("Please enter the following details to add a task:");
            System.out.print(">>> Task name  : ");
            String name = UserInput.nextLine();
            System.out.print(">>> Project name: ");
            String project = UserInput.nextLine();
            System.out.print(">>> Deadline [format: yyyy-mm-dd] : ");
            LocalDate deadline = LocalDate.parse(UserInput.nextLine());
            /* creating new task
            @param name of a task and it cannot be empty or null.
            @param project name of project associated with task, could be an empty string.
            @param deadline The due date of the task in yyyy-mm-dd format*/
            Task newTask= new Task(name, project,deadline);
            addTask(newTask);
            Menus.showMessage("Task added to "+project +" project!");

        } catch (Exception e) {
            Menus.showMessage(e.getMessage());
        }
    }
    public int size() {
        return taskList.size();
    }
    //Counts tasks that are done
    public int completeCount() {
        return (int) taskList.stream()
                .filter(Task::isDone)
                .count();
    }
    // Counts the number of tasks that are not done
    public int incompleteCount() {
        return (int) taskList.stream()
                .filter(task -> !task.isDone())
                .count();
    }
    // Counts the number of tasks that overdue
    public int overdueCount() {
        return (int) taskList.stream()
                .filter(task -> task.getDeadline().isBefore(LocalDate.now()))
                .count();
    }

    public ArrayList<Task> asArray() {
        return taskList;
    }
    //public ArrayList<Task> getTasks(){
      //  return tasks;
    //};
}
