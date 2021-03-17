package main.java.BeeOrderly;


import main.java.BeeOrderly.helpers.Menus;
import main.java.BeeOrderly.helpers.UserInput;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.UUID;



public class ToDoList implements Serializable {
    private final ArrayList<Task> taskList;
    @Serial
    private static final long serialVersionUID= 1L;
    private static Task task;
    private static UUID uuid;


    public ToDoList(){
        taskList = new ArrayList<>();

    }
    /**
     * Adds a Task object in ArrayList
     */
    public void addTask(Task task) {
        taskList.add(task);
    }
    /* creating new task
                @param name of a task and it cannot be empty or null.
                @param project name of project associated with task, could be an empty string.
                @param deadline The due date of the task in yyyy-mm-dd format*/
    //split this method if there's time
    public void createTask() {

        try {
            System.out.println("Please enter the following details to add a task:");
            System.out.print("> Task name  : ");
            String name = UserInput.nextLine();
            System.out.print("> Project name: ");
            String project = UserInput.nextLine();
            System.out.print("> Deadline [format: yyyy-mm-dd] : ");
            LocalDate deadline = LocalDate.parse(UserInput.nextLine());

            Task newTask= new Task(name, project,deadline);
            addTask(newTask);
            Menus.showMessage("Task added to "+project +" project!");

        } catch (Exception e) {
            Menus.showMessage(e.getMessage());
        }
    }
    //returns size of taskList
    public int size() {
        return taskList.size();
    }
    //ToDoList objects can be read as arrays
    public ArrayList<Task> asArray() {
        return taskList;
    }
    //gets tasks by index
    public Task getTask(int index){
        return taskList.get(index);
    }
    public Task getTaskByUUID(UUID uuid){
        return task;
    }
}
