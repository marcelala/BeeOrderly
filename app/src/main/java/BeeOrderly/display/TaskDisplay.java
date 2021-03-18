package main.java.BeeOrderly.display;

import main.java.BeeOrderly.model.Task;
import main.java.BeeOrderly.model.ToDoList;

import java.util.ArrayList;
import java.util.Comparator;

public class TaskDisplay {

    public TaskDisplay() {
    }

    public void printTaskList(ArrayList<Task> taskList) {
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
    public void printNoTasksFound() {
        System.out.println("You gotta add some tasks to your list first!");
    }
}
