package main.java.BeeOrderly;

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
}
