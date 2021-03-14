package main.java.BeeOrderly;



public class Menus {

//Displays the main menu on terminal
public static void mainMenu() {
    System.out.println("\n\nWelcome to Bee Orderly!\n");
    System.out.println(">>> Let's get you in order!\n");
    System.out.println("===================");


    System.out.println("\n*** MAIN MENU ***\n");
    System.out.println("===================\n");

    System.out.println("What would you like to do today?");
    System.out.println("(1) Show your list of saved tasks (filtered by deadline or by project )");
    System.out.println("(2) Add a new task");
    System.out.println("(3) Edit,change status or delete a task");
    System.out.println("(4) Save and quit\n");
    System.out.print("Please enter your choice [1-4]: ");
}
    /**
     * Displays the menu to filter tasks by project or deadline
     * for user selection
     */
    public static void displayTasksMenu() {
        System.out.println("\nHow would you like to view your tasks");
        System.out.println("===================\n");
        System.out.println("Pick an option:");
        System.out.println("(1) by deadline"
                + " [default choice, just press ENTER key]");
        System.out.println("(2) by project");
        System.out.print("\nPlease enter your choice [1-2]: ");
    }

    /**
     * Displays a prompt for user to select the task number to EDIT
     */
    public static void editTaskSelection() {
        System.out.print(">>> Select the task number you want to EDIT and press ENTER key: ");
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
        System.out.println(">>> Bzzzz, your tasks are saved.");
        System.out.println(">>> See you soon!");
    }

    /**
     * This method will display the error message if a user input an option which is not
     * from the choices given in main menu
     */
    public static void unknownMessage() {
        System.out.println(">>> Invalid choice. Please type a number from the menu.");
    }

    /**
     * This message will print the given character on terminal to given number of times
     * @param charToPrint a character given in single quote to print, i.e., '='
     * @param times an integer to repeat printing the given character
     */
    public static void separator (char charToPrint, int times) {
        for (int index = 0; index < times; index++) System.out.print(charToPrint);
        System.out.println("");
    }


}
