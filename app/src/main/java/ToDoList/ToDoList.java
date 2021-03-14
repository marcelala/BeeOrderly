package main.java.ToDoList;




import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;
//import java.util.Iterator;


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
            Menus.showMessage("Task created successfully");

        } catch (Exception e) {
            Menus.showMessage(e.getMessage());
        }
    }
    public int size() {
        return taskList.size();
    }

    //Counts tasks that are done!
    public int completedCount() {
        return (int) taskList.stream()
                .filter(Task::isDone)
                .count();
    }
    // Counts the number of tasks that are not done
    public int notCompletedCount() {
        return (int) taskList.stream()
                .filter(task -> !task.isDone())
                .count();
    }

    public ArrayList<Task> asArray() {
        return taskList;
    }


    //public ArrayList<Task> getTasks(){
      //  return tasks;
    //};



/**
 * Reads input on terminal and updates the Task object in the ArrayList of Tasks
 * @param task the task object
 * @return true, if the Tasks object is updated in ArrayList, otherwise false
 */
    /**public boolean readTaskFromUserToUpdate(Task task) {
            Scanner scan = new Scanner(System.in);
            boolean isTaskUpdated = false;

            try {
                System.out.println("Please enter these details to update the task:"
                        + "\nIf you do not want to change any field, press ENTER!");
                System.out.print(">>> Task name  : ");
                String name = scan.nextLine();
                if (!(name.trim().equals("") || name == null)) {
                    task.setName(name);
                    isTaskUpdated = true;
                }

                System.out.print(">>> Project Name: ");
                String project = scan.nextLine();
                if (!(project.trim().equals("") || project == null)) {
                    task.setProject(project);
                    isTaskUpdated = true;
                }

                System.out.print(">>> Deadline [format: yyyy-mm-dd] : ");
                String deadline = scan.nextLine();
                if (!(deadline.trim().equals("") || deadline == null)) {
                    task.setDeadline(LocalDate.parse(deadline));
                    isTaskUpdated = true;
                }


                Menus.showMessage("The task was " + (isTaskUpdated ? "updated successfully" : "not updated") + ": Returning to Main Menu");

                return true;
            } catch (Exception e) {
                Menus.showMessage(e.getMessage());
                return false;
            }
        }*/




}
