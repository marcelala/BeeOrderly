package main.java.ToDoList;

import java.io.*;

public class FileManager {

    private ToDoList taskList;
    private String path = "src/main/resources/";
    private String fileName = "taskList.txt";


    public FileManager(ToDoList taskList) {
        this.taskList = taskList;
    }


    //writes the data of Tasks from ArrayList to data file on tasks.obj
    public boolean saveToFile(String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(taskList);

            objectOutputStream.close();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            Menu.showMessage(e.getMessage());
            return false;
        }
    }

    //reads the data file from task.obj which contains data of previously saved tasks
    public boolean readFromFile(String fileName) {
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
