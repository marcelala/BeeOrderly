package main.java.BeeOrderly.tools;

import main.java.BeeOrderly.model.Task;
import main.java.BeeOrderly.model.ToDoList;
import main.java.BeeOrderly.helpers.Menus;

import java.time.LocalDate;

public class TaskCounter {

    ToDoList taskList;

    public TaskCounter(ToDoList taskList){
        this.taskList = taskList;
    }
    //Counts tasks that are done
    public int completeCount() {
        return (int) taskList.asArray().stream()
                .filter(Task::isDone)
                .count();
    }
    // Counts the number of tasks that are not done
    public int incompleteCount() {
        return (int) taskList.asArray().stream()
                .filter(task -> !task.isDone())
                .count();
    }
    // Counts the number of tasks that overdue
    public int overdueCount() {
        return (int) taskList.asArray().stream()
                .filter(task -> task.getDeadline().isBefore(LocalDate.now()))
                .count();
    }

    public void printCount(){
        System.out.println("\nYou have completed "+  completeCount()
                +" task(s) so far! Still got "+ incompleteCount() + " to go.\n");
        Menus.showMessage("Reminder: You might wanna checkout your lists, "
                + overdueCount() + " task(s) could be overdue!");
    }
}
