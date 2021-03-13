package main.java.ToDoList;

import java.io.*;

public class FileManager {

    private ToDoList taskList;
    private String path = "app/src/main/resources/";
    private String fileName = "tasks.txt";


    public FileManager( ) {
        this.taskList =  new ToDoList();
    }


    //writes the data of Tasks from ArrayList to data file on tasks.obj
    public boolean saveToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(taskList);

            objectOutputStream.close();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            Menus.showMessage(e.getMessage());
            return false;
        }
    }

    //reads the data file from task.obj which contains data of previously saved tasks
    public boolean readFromFile() {
        boolean status = false;

        try {
            FileInputStream fileInputStream = new FileInputStream(path + fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            taskList = (ToDoList) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            return true;

        } catch (IOException | ClassNotFoundException exception){
            System.out.println("There is a problem loading the file: " + exception);
            return false;
        }

    }


}
