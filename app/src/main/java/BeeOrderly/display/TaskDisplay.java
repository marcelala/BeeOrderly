package main.java.BeeOrderly.display;

import main.java.BeeOrderly.model.Task;
import main.java.BeeOrderly.model.ToDoList;

import java.util.ArrayList;
/**
 * The TaskDisplay class has methods that print the to-do lists for the user.
 * @author Marcela F
 * @version 1.0 (2021.03.18)
 */
public class TaskDisplay {

    public TaskDisplay() {
    }

    public void printSortedTaskList(ArrayList<Task> taskList) {
        if (taskList.size() <= 0) {
            System.out.println("You gotta add some tasks to your list first!");
        } else {
            System.out.println("Bee Orderly To-do List");
            Menus.separator('=', 75);
            String displayFormat = "%-25s %-35s %-20s %-20s";
            System.out.printf((displayFormat) + "%n", "TASK", "PROJECT", "DEADLINE", "COMPLETED?");
            System.out.printf((displayFormat) + "%n", "=====", "=======", "========", "=========");
            taskList.forEach(task -> System.out.printf((displayFormat) + "%n",
                    task.getName(),
                    task.getProject(),
                    task.getDeadline(),
                    (task.isDone() ? "Yes" : "Not yet")));
        }
    }


    public void printTasksWithIndex(ToDoList taskList) {
        if (taskList.size() <= 0) {
            System.out.println("You gotta add some tasks to your list first!");
        } else {
            Menus.separator('=', 75);
            System.out.println("Bee Orderly To-do List");
            Menus.separator('=', 75);
            String displayFormat = "%-4s%-25s %-35s %-20s %-20s";
            System.out.printf((displayFormat) + "%n", "NUM", "TASK", "PROJECT", "DEADLINE", "COMPLETED?");
            System.out.printf((displayFormat) + "%n", "===", "=================", "=======", "========", "=========");
            taskList.asArray().forEach(task -> System.out.printf((displayFormat) + "%n",
                    taskList.asArray().indexOf(task) + 1,
                    task.getName(),
                    task.getProject(),
                    task.getDeadline(),
                    (task.isDone() ? "Yes" : "Not yet")));
        }
    }
}