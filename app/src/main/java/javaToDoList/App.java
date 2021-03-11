package javaToDoList;


import java.util.Scanner;



public class App {
    // A string to hold the data file name which contains all tasks and their details
    public static String filename = "tasks.obj";

    //main method of the app
    public static void main(String[] args) {


        // An object of TodoList to hold all tasks and their data
        ToDoList toDoList = new ToDoList();

        //A string to hold the choice that will be entered by the user
        String menuChoice = "-10";

        try {


            Scanner input = new Scanner(System.in);


            Menu.showMessage("Let's do this!");
            while (!menuChoice.equals("4")) {
                Menu.mainMenu();
                menuChoice = input.nextLine();

                switch (menuChoice) {
                    case "1":
                        Menu.listAllTasksMenu();
                        //toDoList.listAllTasks(input.nextLine());
                        break;
                    case "2":
                        toDoList.readTaskFromUser();
                        break;
                    case "3":
                        toDoList.displayAllTasksWithIndex();
                        Menu.editTaskSelection();
                        toDoList.editTask(input.nextLine());
                        break;
                    case "4":
                        break;

                    default:
                        Menu.unknownMessage();
                }
                input.close();

            }
            toDoList.saveToFile(filename);
            Menu.byeMessage();

        }catch (Exception e) {
            Menu.showMessage("UNCAUGHT EXCEPTION THROWN");
            System.out.println("Trying to write the unsaved data of all tasks in data file");
            toDoList.saveToFile(filename);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
}
