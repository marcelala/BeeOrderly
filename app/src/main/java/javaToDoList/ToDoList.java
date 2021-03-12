package javaToDoList;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Scanner;



public class ToDoList{
    private ArrayList<Task> taskList;




    public ToDoList(){

        taskList = new ArrayList<>();
    }

    /**
     * Adds a Task object in ArrayList
     * @param name of a task and it cannot be empty or null.
     * @param project name of project associated with task, could be an empty string.
     * @param deadline The due date of the task in yyyy-mm-dd format
     */
    public void addTask(String name, String project, LocalDate deadline) {
        this.taskList.add(new Task (name, project, deadline));
    }


    /**
     * Reads input on terminal to create a Task object and to add in the ArrayList
     * @return true, if the Tasks object is added to ArrayList, otherwise false
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
            scan.close();

            this.taskList.add(new Task(title, project, deadline));
            Menu.showMessage("Task is added successfully");

            return true;
        } catch (Exception e) {
            Menu.showMessage(e.getMessage());
            return false;
        }
    }

/**
 * Reads input on terminal and updates the Task object in the ArrayList of Tasks
 * @param task the task object
 * @return true, if the Tasks object is updated in ArrayList, otherwise false
 */
        public boolean readTaskFromUserToUpdate(Task task) {
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
                }             scan.close();


                Menu.showMessage("The task was " + (isTaskUpdated ? "updated successfully" : "not updated") + ": Returning to Main Menu");

                return true;
            } catch (Exception e) {
                Menu.showMessage(e.getMessage());
                return false;
            }
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
            if (taskIndex < 0 || taskIndex > taskList.size()) {
                throw new ArrayIndexOutOfBoundsException("This task number was not created yet : Returning to Main Menu");
            }

            Task task = taskList.get(taskIndex);

            Menu.showMessage("Task number " + selectedTask + "  is selected:" + task.formattedStringOfTask());

            Menu.editTaskMenu();
            Scanner scan = new Scanner(System.in);
            String editChoice = scan.nextLine();
            switch (editChoice) {
                case "1":
                    readTaskFromUserToUpdate(task);
                    break;
                case "2":
                    task.setDone();
                    Menu.showMessage("Task number " + selectedTask + " is done! : Returning to Main Menu");
                    break;
                case "3":
                    taskList.remove(task);
                    Menu.showMessage("Task number " + selectedTask + " was deleted : Returning to Main Menu");
                    break;
                default:
                    Menu.showMessage("Returning to Main Menu");
            }
                } catch (Exception e) {
                    Menu.showMessage(e.getMessage());
        }

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

    /**
     * Displays all tasks with index numbers
     */
    public void displayAllTasksWithIndex() {
        String displayFormat = "%-4s%-35s %-20s %-10s %-10s";

        if (taskList.size()>0) {
            System.out.println(String.format(displayFormat,"NUM","Name","Project","Deadline","Completed"));
            System.out.println(String.format(displayFormat,"===","=====","=======","========","========="));
        } else {
            System.out.println("You haven't added any tasks yet!");
        }

        taskList.stream()
                .forEach(task -> System.out.println(String.format(displayFormat,
                        taskList.indexOf(task)+1,
                        task.getName(),
                        task.getProject(),
                        task.getDeadline(),
                        (task.isDone()?"Yes":"No")
                )));
    }

//writes the data of Tasks from ArrayList to data file on tasks.obj
    public boolean saveToFile(String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(taskList);

            objectOutputStream.close();
            fileOutputStream.close();
            return true;

        } catch (Exception e) {
            Menu.showMessage(e.getMessage());
            return false;
        }
    }

    //reads the data file from task.obj which contains data of previously saved tasks
    public boolean readFromFile(String filename) {
        boolean status = false;

        try {
            if (!Files.isReadable(Paths.get(filename))) {
                Menu.showMessage("The data file " + filename + " does not exist");
                return false;
            }
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            taskList = (ArrayList<Task>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return true;

        } catch (Exception e) {
            Menu.showMessage(e.getMessage());
            return false;
        }
    }

    public void listAllTasks(String sortBy) {
        Menu.separator('=',75);
        System.out.println(
                "Total Tasks = " + taskList.size() +
                        "\t\t (Completed = " + completedCount() + "\t\t" +
                        " Not Completed = " + notCompletedCount() +
                        " )");

        if (sortBy.equals("2")) {
            String displayFormat = "%-20s %-35s %-10s %-10s";

            if (taskList.size()>0) {
                System.out.println(String.format(displayFormat,"Project","Name","Deadline","Completed?"));
                System.out.println(String.format(displayFormat,"=======","=====","========","========="));
            } else {
                System.out.println("No tasks to show");
            }

            taskList.stream()
                    .sorted(Comparator.comparing(Task::getProject))
                    .forEach(task -> System.out.println(String.format(displayFormat,task.getProject(),
                            task.getName(),
                            task.getDeadline(),
                            (task.isDone()?"YES":"NO")
                    )));
        } else {
            String displayFormat = "%-10s %-35s %-20s %-10s";

            if (taskList.size() > 0) {
                System.out.println(String.format(displayFormat,"Deadline","Name","Project" , "COMPLETED"));
                System.out.println(String.format(displayFormat,"========","=====","=======" , "========="));
            } else {
                System.out.println("No tasks to show");
            }

            taskList.stream()
                    .sorted(Comparator.comparing(Task::getDeadline))
                    .forEach(task -> System.out.println(String.format(displayFormat,task.getDeadline(),
                            task.getName(),
                            task.getProject(),
                            (task.isDone() ? "YES" : "NO")
                    )));
        }
    }











}
