package main.java.BeeOrderly.tools;

import main.java.BeeOrderly.display.Menus;
import main.java.BeeOrderly.model.ToDoList;

import java.io.*;
/**
 * The FileManager class handles reading and writing tasks' data to file.
 * @author Marcela F
 * @version 1.0 (2021.03.18)
 */
public class FileManager {

    private ToDoList taskList;
    private final String path = "app/src/main/resources/";
    private final String fileName = "tasks.txt";
    @Serial
    private static final long serialVersionUID= 1L;


    public FileManager( ) {
    }

    //writes the data of Tasks from ArrayList to data file on tasks.txt
    public void saveToFile(ToDoList taskList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(taskList);

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            Menus.showMessage(e.getMessage());
        }
    }

    //reads the data file from task.txt which contains data of previously saved tasks
    public ToDoList loadFromFile() {
        boolean status = false;

        try {
            FileInputStream fileInputStream = new FileInputStream(path + fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            taskList = (ToDoList) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return taskList;


        } catch (EOFException e) {
          return new ToDoList();

        } catch (IOException | ClassNotFoundException exception){
            System.out.println("There is a problem loading the file: " + exception);
            exception.printStackTrace();
            return new ToDoList();
        }
    }
}
