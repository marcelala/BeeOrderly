package main.java.BeeOrderly;

import java.time.LocalDate;

public class TaskEditor {

     ToDoList taskList;
     //ArrayList <Task> tasks;

    public TaskEditor(ToDoList taskList){
        this.taskList = taskList;
    }
    /*Displays all tasks with index numbers */
    public void displayTasksWithIndex() {

        String displayFormat = "%-4s%-35s %-20s %-20s %-20s";
        if (taskList.size()>0) {
            System.out.printf((displayFormat) + "%n","NUM","Name","Project","Deadline","Completed?");
            System.out.printf((displayFormat) + "%n","===","=================","=======","========","=========");
        } else {
            System.out.println("You haven't added any tasks yet!");
        }

        taskList.asArray()
                .forEach(task -> System.out.printf((displayFormat) + "%n",
                        taskList.asArray().indexOf(task)+1,
                        task.getName(),
                        task.getProject(),
                        task.getDeadline(),
                        (task.isDone()?"Yes":"No")
                ));
    }
    /**
     * Selects a Task object from ArrayList to edit
     * @param selectedTask Task number that is selected by user from given list to perform editing operations
     * @throws NullPointerException if task number of given as empty string or null
     * @throws ArrayIndexOutOfBoundsException if task number does not fall in index range of ArrayList
     */
    public void editTask(String selectedTask) throws NullPointerException {
        try {
            // checking if the task number is given and empty string or null
            if (selectedTask.trim().equals("") || selectedTask == null) {
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
     * @param task the task object
     * @return true, if the Tasks object is updated in ArrayList, otherwise false
     */
    public boolean readTaskFromUserToUpdate(Task task) {
     boolean isTaskUpdated = false;

        try {
     System.out.println("Please enter these details to update the task:"
     + "\nIf you do not want to change any field, press ENTER!");
     System.out.print(">>> Task name  : ");
     String name = UserInput.nextLine();
     if (!(name.trim().equals("") || name == null)) {
     task.setName(name);
     isTaskUpdated = true;
     }

     System.out.print(">>> Project Name: ");
     String project = UserInput.nextLine();
     if (!(project.trim().equals("") || project == null)) {
     task.setProject(project);
     isTaskUpdated = true;
     }
     System.out.print(">>> Deadline [format: yyyy-mm-dd] : ");
     String deadline = UserInput.nextLine();
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
     }
}
