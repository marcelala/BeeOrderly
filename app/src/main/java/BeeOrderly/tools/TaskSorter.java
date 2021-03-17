package main.java.BeeOrderly.tools;

import main.java.BeeOrderly.Task;
import main.java.BeeOrderly.ToDoList;
import main.java.BeeOrderly.helpers.Menus;

import java.util.ArrayList;
import java.util.Comparator;


public class TaskSorter {

    private final ArrayList<Task> taskList;

    public TaskSorter(ToDoList taskList){
        this.taskList = taskList.asArray();
    }

    /**
     * A method to display the contents of ArrayList
     * @param sortBy a string holding a number, "2" for sorting by project, otherwise it will sort by date
     */
    public void sortAllTasks(String sortBy) {
        Menus.separator('=',75);
        System.out.println("Total Tasks = " + taskList.size()); Menus.separator('=',75);

        if (sortBy.equals("2")) {
            String displayFormat = "%-25s %-35s %-20s %-20s";
            if (taskList.size()>0) {
                System.out.printf((displayFormat) + "%n","PROJECT","TASK","DEADLINE","COMPLETED?");
                System.out.printf((displayFormat) + "%n","=======","=====","========","=========");
            } else {System.out.println("No tasks to show");}
            taskList.stream()
                    .sorted(Comparator.comparing(Task::getProject))
                    .forEach(task -> System.out.printf((displayFormat) + "%n",task.getProject(),
                            task.getName(), task.getDeadline(), (task.isDone()?"Yes":"Not yet")
                    ));
        } else {
            String displayFormat = "%-25s %-35s %-20s %-20s";
            if (taskList.size() > 0) {
                System.out.printf((displayFormat) + "%n","DEADLINE","TASK","PROJECT" , "COMPLETED?");
                System.out.printf((displayFormat) + "%n","========","=====","=======" , "=========");
            } else {System.out.println("You gotta add some tasks first! ");}
            taskList.stream()
                    .sorted(Comparator.comparing(Task::getDeadline))
                    .forEach(task -> System.out.printf((displayFormat) + "%n",task.getDeadline(),
                            task.getName(), task.getProject(), (task.isDone() ? "Yes" : "Not yet")
                    ));
        }
    }
}
