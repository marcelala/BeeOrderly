package main.java.BeeOrderly;


import main.java.BeeOrderly.display.TaskDisplay;
import main.java.BeeOrderly.model.Task;
import main.java.BeeOrderly.tools.FileManager;
import main.java.BeeOrderly.display.Menus;
import main.java.BeeOrderly.tools.UserInput;
import main.java.BeeOrderly.model.ToDoList;
import main.java.BeeOrderly.tools.TaskCounter;
import main.java.BeeOrderly.tools.TaskEditor;
import main.java.BeeOrderly.tools.TaskSorter;

import java.util.ArrayList;
/**
 * The Main class contains the Main Menu.
 * @author Marcela F
 * @version 1.0 (2021.03.18)
 */
public class BeeOrderlyApp {

    public BeeOrderlyApp(){ }

    //main method of the app
    public static void main(String[] args) {

        //A string to hold the choice that will be entered by the user
        String menuChoice = "-10";
        FileManager fileManager = new FileManager();
        UserInput userInput = new UserInput();

        try {

            ToDoList taskList = fileManager.loadFromFile();

            TaskCounter taskCounter = new TaskCounter(taskList);


            Menus.showMessage("Let's get you in order!\n");
            while (!menuChoice.equals("4")) {
                Menus.mainMenu();

                menuChoice = UserInput.nextLine();

                switch (menuChoice) {
                    //(1) view tasks sorted by project or deadline
                    case "1":
                        Menus.displayTasksMenu();
                        String sortOption = UserInput.nextLine();
                        ArrayList<Task> sortedTasks = new TaskSorter(taskList).sortAllTasks(sortOption);
                        new TaskDisplay().printSortedTaskList(sortedTasks);
                        taskCounter.printCount();
                        break;
                        //(2) add a new task
                        case "2":
                        try {
                            Task task = userInput.createTask();
                            taskList.addTask(task);
                            taskCounter.printCount();
                            fileManager.saveToFile(taskList);
                        } catch (Exception e) {
                            Menus.showMessage("Error creating task: " + e.getMessage());
                        }
                        break;
                        //(3) edit or remove tasks
                        case "3":
                        new TaskDisplay().printTasksWithIndex(taskList);
                        Menus.editTaskSelection();
                        new TaskEditor(taskList).editTask(UserInput.nextLine());
                        taskCounter.printCount();
                        break;
                        //(4) save and quit
                    case "4":
                        fileManager.saveToFile(taskList);
                        break;
                    default:
                        Menus.unknownMessage();
                }
            }
            Menus.byeMessage();
        }catch (Exception e) {
            Menus.showMessage("UNCAUGHT EXCEPTION THROWN");
            System.out.println("Buzzzzzz... There was a problem while trying to write the unsaved data of all tasks in data file");
            System.out.println(e);
        }
    }
}
