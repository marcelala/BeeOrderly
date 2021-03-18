package main.java.BeeOrderly.tools;

import main.java.BeeOrderly.display.TaskDisplay;
import main.java.BeeOrderly.model.Task;
import main.java.BeeOrderly.model.ToDoList;
import main.java.BeeOrderly.display.Menus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TaskSorter {

    private final ArrayList<Task> taskList;
    private TaskDisplay taskDisplay = new TaskDisplay();

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
