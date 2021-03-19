package main.java.BeeOrderly.tools;

import main.java.BeeOrderly.model.Task;
import main.java.BeeOrderly.model.ToDoList;
import main.java.BeeOrderly.display.Menus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * The TaskSorter class handles methods for sorting Task objects. Sorting is performed
 * either by project or deadline.
 * @author Marcela F
 * @version 1.0 (2021.03.18)
 */

public class TaskSorter {

    private final ArrayList<Task> taskList;

    public TaskSorter(ToDoList taskList){

        this.taskList = taskList.asArray();
    }

    /**
     * Displays the contents of ArrayList
     * @param sortBy a string holding a number, "2" for sorting by project, otherwise it will sort by date
     */
    //split this method
    public ArrayList<Task> sortAllTasks(String sortBy) {
        Menus.separator('=',75);
        if (sortBy.equals("2")){

            return taskList.stream()
                    .sorted(Comparator.comparing(Task::getProject))
                    .collect(Collectors.toCollection(ArrayList::new));


    } else {

            return taskList.stream()
                    .sorted(Comparator.comparing(Task::getDeadline))
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }
}
