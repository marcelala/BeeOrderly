package main.java.ToDoList;



public class App {
    // A string to hold the data file name which contains all tasks and their details
    //public static String filename = "tasks.txt";
    private ToDoList taskList;
    private TaskCreator creator;
    //private TaskEditor editor;
    //private TaskSorter sorter;
    private FileManager fileManager;

    public App(){
        // An object of TodoList to hold all tasks and their data
        this.taskList = new ToDoList();
        //this.sorter = new TaskSorter();
        this.creator= new TaskCreator();
        //this.userInput = new UserInput();
        //this.editor = new TaskEditor();
        this.fileManager = new FileManager();

    }

    //main method of the app
    public static void main(String[] args) {

        //A string to hold the choice that will be entered by the user
        String menuChoice = "-10";
         UserInput userInput= new UserInput();

        try {

            Menus.showMessage("Let's do this!");
            while (!menuChoice.equals("4")) {
                Menus.mainMenu();

                menuChoice = userInput.nextLine();

                switch (menuChoice) {
                    case "1":
                        Menus.displayTasksMenu();
                        //Sorter.listAllTasks(input.nextLine());
                        break;
                    case "2":
                        //UserInput userInput = new UserInput();
                        TaskCreator creator = new TaskCreator();
                        creator.createTask();
                        break;
                    case "3":
                        //taskList.displayAllTasksWithIndex();
                        Menus.editTaskSelection();
                        //taskList.editTask(userInput.nextLine());
                        break;
                    case "4":
                        //fileManager.saveToFile();
                        break;

                    default:
                        Menus.unknownMessage();

                }

            }
            //toDoList.saveToFile(filename);
            Menus.byeMessage();

        }catch (Exception e) {
            Menus.showMessage("UNCAUGHT EXCEPTION THROWN");
            System.out.println("Problem while trying to write the unsaved data of all tasks in data file");
            //toDoList.saveToFile(filename);
            System.out.println(e.getMessage());
            //System.out.println(e.getStackTrace());
        }
    }
}
