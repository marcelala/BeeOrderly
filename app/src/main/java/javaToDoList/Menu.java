package javaToDoList;



public class Menu {

//Displays the main menu on terminal
public static void mainMenu() {
    System.out.println("\nMAIN MENU");
    System.out.println("===========\n");

    System.out.println("Pick an option:");
    System.out.println("(1) Show Task List (filtered by deadline or by project )");
    System.out.println("(2) Add a new task");
    System.out.println("(3) Edit a task (update, mark as done, remove)");
    System.out.println("(4) Save and Quit\n");
    System.out.print("Please enter your choice [1-4]: ");
}
    /**
     * Displays the menu to filter tasks by project or deadline
     * for user selection
     */
    public static void listAllTasksMenu() {
        System.out.println("\nDisplay All Tasks");
        System.out.println("===================\n");
        System.out.println("Pick an option:");
        System.out.println("(1) View task list by deadline"
                + " [default choice, just press ENTER key]");
        System.out.println("(2) Show task list by project");
        System.out.print("\nPlease enter your choice [1-2]: ");
    }

    /**
     * Displays a prompt for user to select the task number to EDIT
     */
    public static void editTaskSelection() {
        System.out.print(">>> Select a task number to EDIT and press ENTER key: ");
    }

    /**
     * Displays the Edit menu options on terminal
     * for user selection
     */
    public static void editTaskMenu() {
        System.out.println("\nTask Edit Options");
        System.out.println("======================\n");
        System.out.println("Pick an option:");
        System.out.println("(1) Modify selected task");
        System.out.println("(2) Mark selected task as COMPLETED");
        System.out.println("(3) Delete selected task");
        System.out.println("(4) Return to main menu ");
        System.out.print("\nPlease enter your choice [1-4]: ");
    }

    /**
     * Displays any given message on terminal
     * @param message a text message as String
     */
    public static void showMessage(String message) {

        System.out.println(">>> " + message);
    }
    /**
     * Goodbye message
     */
    public static void  byeMessage() {
        System.out.println(">>> All tasks are saved");
        System.out.println(">>> Goodbye");
    }

    /**
     * This method will display the error message if a user input an option which is not
     * from the choices given in main menu
     */
    public static void unknownMessage() {
        System.out.println(">>> Invalid choice: Please type a number from the menu ");
    }



}
