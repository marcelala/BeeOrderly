package main.java.ToDoList;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskCreator implements Serializable {

    private final UserInput userInput;
    private ArrayList<Task> tasks;
    private ToDoList taskList;

    public TaskCreator() {
        tasks = new ArrayList<Task>();
        this.userInput = new UserInput();
    }
    /*** Reads input on terminal to create a Task object and to add in the ArrayList
     * @return true, if the Tasks object is added to ArrayList, otherwise false
            */
    public boolean createTask() {
        FileManager fileManager = new FileManager();

        try {
            System.out.println("Please enter the following details to add a task:");
            System.out.print(">>> Task name  : ");
            String name = userInput.nextLine();
            System.out.print(">>> Project name: ");
            String project = userInput.nextLine();
            System.out.print(">>> Deadline [format: yyyy-mm-dd] : ");
            LocalDate deadline = LocalDate.parse(userInput.nextLine());

            Task task = new Task(name, project, deadline);
                fileManager.saveToFile();

            Menus.showMessage("Task created successfully");
            return true;

        } catch (Exception e) {
            Menus.showMessage(e.getMessage());
            return false;
        }
    }
}

