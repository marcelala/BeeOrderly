package javaToDoList;


import java.util.Scanner;



public class Main {

    public static void main(String args[]) {
        // An object of TodoList to hold all tasks and their data
        ToDoList toDoList = new ToDoList();

        //A string to hold the choice that will be entered by the user
        String menuChoice = "-16";


            Scanner input = new Scanner(System.in);


            Menu.showMessage("Let's do this!");
        while (!menuChoice.equals("4")) {
            Menu.mainMenu();
            menuChoice = input.nextLine();

                switch (menuChoice) {
                    case "1":
                        Menu.listAllTasksMenu();
                       // toDoList.listAllTasks(input.nextLine());
                        break;
                    case "2":
                        //toDoList.readTaskFromUser();
                        break;
                    case "3":
                        Menu.editTaskSelection();
                        break;
                    case "4":
                        break;

                    default:
                        Menu.unknownMessage();
                }
            }




}
}