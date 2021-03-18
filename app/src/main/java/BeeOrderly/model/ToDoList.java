package main.java.BeeOrderly.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

/**
 * The ToDoList class creates an ArrayList of Tasks which are added to the Arraylist. It's methods allow the
 * application to add tasks and retrieve them.
 * @author Marcela F
 * @version 1.0 (2021.03.18)
 */
public class ToDoList implements Serializable {
    private final ArrayList<Task> taskList;
    @Serial
    private static final long serialVersionUID= 1L;

    public ToDoList(){
        taskList = new ArrayList<>();
    }
    /**
     * Adds a Task object in ArrayList
     */
    public void addTask(Task task) {
        taskList.add(task);
    }
    //returns size of taskList
    public int size() {
        return taskList.size();
    }
    //ToDoList objects can be read as arrays
    public ArrayList<Task> asArray() {
        return taskList;
    }
    //gets tasks by index
    public Task getTask(int index){
        return taskList.get(index);
    }

    public Task getTaskByUUID(UUID uuid){
        Optional<Task> taskFound = taskList.stream().filter((task) -> task.getUuid().equals(uuid)).findFirst();

        return taskFound.orElse(null);
    }
}
