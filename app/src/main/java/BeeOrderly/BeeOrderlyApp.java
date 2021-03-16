package main.java.BeeOrderly;


public class BeeOrderlyApp {
    // A string to hold the data file name which contains all tasks and their details
    //public static String filename = "tasks.txt";

    public BeeOrderlyApp(){
    }

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
                        new TaskSorter(taskList).listAllTasks(UserInput.nextLine());
                        System.out.println("\nYou have completed "+  taskCounter.completeCount()
                                +" task(s) so far! Still got "+ taskCounter.incompleteCount() + " to go.");
                        Menus.showMessage("\nReminder: You might wanna checkout your lists, "
                                + taskCounter.overdueCount() + " task(s) could be overdue!");
                        break;
                    case "2":
                        taskList.createTask();
                        System.out.println("\nYou have completed "+  taskCounter.completeCount()
                                +" task(s) so far! Still got "+ taskCounter.incompleteCount() + " to go.");
                        Menus.showMessage("\nReminder: You might wanna checkout your lists, "
                                + taskCounter.overdueCount() + " task(s) could be overdue!");
                        fileManager.saveToFile(taskList);
                        break;
                    case "3":
                        new TaskEditor(taskList).displayTasksWithIndex();
                        Menus.editTaskSelection();
                        new TaskEditor(taskList).editTask(UserInput.nextLine());
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
            System.out.println("Bzzzzzz... There was a problem while trying to write the unsaved data of all tasks in data file");
            System.out.println(e);
        }
    }
}
