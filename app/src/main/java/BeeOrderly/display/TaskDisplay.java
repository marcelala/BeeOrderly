package main.java.BeeOrderly.display;

import main.java.BeeOrderly.model.Task;
import main.java.BeeOrderly.model.ToDoList;

import java.util.Comparator;

public class TaskDisplay {

        TaskDisplay taskDisplay= new TaskDisplay();
    public TaskDisplay(){
    }

     public void printTaskList(ToDoList taskList){
        Menus.separator('=',75);
        System.out.println("Bee Orderly To-do List \n Total Tasks = " + taskList.size()); Menus.separator('=',75);
            String displayFormat = "%-25s %-35s %-20s %-20s";
                System.out.printf((displayFormat) + "%n","TASK","PROJECT","DEADLINE","COMPLETED?");
                System.out.printf((displayFormat) + "%n","=====","=======","========","=========");
    }
    public void printNoTasksFound(){
        System.out.println("You gotta add some tasks to your list first!");
    }
}
