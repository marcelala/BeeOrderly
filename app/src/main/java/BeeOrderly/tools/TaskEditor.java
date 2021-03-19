package main.java.BeeOrderly.tools;

import main.java.BeeOrderly.model.Task;
import main.java.BeeOrderly.model.ToDoList;
import main.java.BeeOrderly.display.Menus;

import java.time.LocalDate;

/**
 * The TaskEditor class handles methods for editing, removing or changing the status of Task objects.
 *
 * @author Marcela F
 * @version 1.0 (2021.03.18)
 */
public class TaskEditor {

    ToDoList taskList;

    public TaskEditor(ToDoList taskList) {
        this.taskList = taskList;
    }

    /**
     * Selects a Task object from ArrayList to edit
     *
     * @param selectedTask Task number that is selected by user from given list to perform editing operations
     * @throws NullPointerException           if task number of given as empty string or null
     * @throws ArrayIndexOutOfBoundsException if task number does not fall in index range of ArrayList
     *                                        improve this method
     */
//polish this method
    public void editTask(String selectedTask) throws NullPointerException {
        try {
            // checking if the task number is given and empty string or null
            if (selectedTask.trim().equals("")) {
                throw new NullPointerException("This task does not exist : Returning to Main Menu");
            }
            int taskIndex = Integer.parseInt(selectedTask) - 1;
            if (taskIndex < 0 || taskIndex > taskList.asArray().size()) {
                throw new ArrayIndexOutOfBoundsException("This task number was not created yet : Returning to Main Menu");
            }

            Task task = taskList.asArray().get(taskIndex);

            Menus.showMessage("Task number " + selectedTask + "  is selected:" + task.formattedStringOfTask());
            Menus.editTaskMenu();
            String editChoice = UserInput.nextLine();
            switch (editChoice) {
                case "1" -> readTaskFromUserToUpdate(task);
                case "2" -> {
                    task.setDone();
                    Menus.showMessage("Task number " + selectedTask + " is done! : Returning to Main Menu");
                }
                case "3" -> {
                    taskList.asArray().remove(task);
                    Menus.showMessage("Task number " + selectedTask + " was deleted : Returning to Main Menu");
                }
                default -> Menus.showMessage("Returning to Main Menu");
            }
        } catch (Exception e) {
            Menus.showMessage(e.getMessage());
        }
    }

    /**
     * Reads input on terminal and updates the Task object in the ArrayList of Tasks
     *
     * @param task the task object
     */
    public void readTaskFromUserToUpdate(Task task) {
          boolean isTaskUpdated;

        try {
               isTaskUpdated = renameTask(task);

               isTaskUpdated = renameProject(task) || isTaskUpdated ;

               isTaskUpdated = updateDeadline(task) || isTaskUpdated;

            Menus.showMessage("The task was " + (isTaskUpdated ? "updated successfully" : "not updated") +
                    ": Returning to Main Menu");
        } catch (Exception e) {
            Menus.showMessage(e.getMessage());
        }
    }
    public boolean renameTask(Task task) {
        System.out.println("Please enter these details to update the task:"
                + "\nIf you do not want to change any field, press ENTER!");
        System.out.print(">>> Task name  : ");
        String name = UserInput.nextLine();
        if (!(name.trim().equals("") || name == null)) {
            task.setName(name);
         return true;
        }
        return false;
    }

    public boolean renameProject(Task task) {
        System.out.print(">>> Project Name: ");
        String project = UserInput.nextLine();
        if (!(project.trim().equals("") || project == null)) {
            task.setProject(project);
             return true;
        }
        return false;
    }

    public boolean updateDeadline(Task task) {
        System.out.print(">>> Deadline [format: yyyy-mm-dd] : ");
        String deadline = UserInput.nextLine();
        if (!(deadline.trim().equals("") || deadline == null)) {
            task.setDeadline(LocalDate.parse(deadline));
            return true;
        }
        return false;
    }
}