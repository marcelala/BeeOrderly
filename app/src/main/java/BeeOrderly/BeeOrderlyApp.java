package main.java.BeeOrderly;


import main.java.BeeOrderly.helpers.FileManager;
import main.java.BeeOrderly.helpers.Menus;
import main.java.BeeOrderly.helpers.UserInput;
import main.java.BeeOrderly.tools.TaskCounter;
import main.java.BeeOrderly.tools.TaskEditor;
import main.java.BeeOrderly.tools.TaskSorter;

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
                    case "1":
                        Menus.displayTasksMenu();
                        new TaskSorter(taskList).sortAllTasks(UserInput.nextLine());
                        taskCounter.printCount();
                        break;
                    case "2":
                        taskList.createTask();
                        taskCounter.printCount();
                        fileManager.saveToFile(taskList);
                        break;
                    case "3":
                        new TaskEditor(taskList).displayTasksWithIndex();
                        Menus.editTaskSelection();
                        new TaskEditor(taskList).editTask(UserInput.nextLine());
                        taskCounter.printCount();
                        break;
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
