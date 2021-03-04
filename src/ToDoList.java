import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;



public class ToDoList {
    String project;
    private ArrayList<Task> taskList;




    public ToDoList(){
        taskList = new ArrayList<>();
    }

    /**
     * Adds a Task object in ArrayList
     * @param name name of a task and it cannot be empty or null.
     * @param project name of project associated with task, could be an empty string.
     * @param deadline The due date of the task in yyyy-mm-dd format
     */
    public void addTask(String name, String project, LocalDate deadline) {
        this.taskList.add(new Task (name, project, deadline));
    }



    /**
     * Reads input on terminal
     * to create a Task object and to add in the ArrayList of Tasks
     * @return true, if the Tasks object is created and added to ArrayList, otherwise false
     */
    public boolean readTaskFromUser() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Please enter the following details to add a task:");
            System.out.print(">>> Task name  : ");
            String title = scan.nextLine();
            System.out.print(">>> Project name: ");
            String project = scan.nextLine();
            System.out.print(">>> Deadline [format: yyyy-mm-dd] : ");
            LocalDate deadline = LocalDate.parse(scan.nextLine());

            this.taskList.add(new Task(title,project,deadline));
            Menu.showMessage("Task is added successfully");

            return true;
        } catch (Exception e) {
            Menu.showMessage(e.getMessage());
            return false;
        }










    }






}
