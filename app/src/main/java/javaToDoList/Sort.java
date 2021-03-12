package javaToDoList;

import java.util.ArrayList;
import java.util.Comparator;


public class Sort extends ToDoList{

    private ArrayList<Task> taskList;



    /**
     * A method to display the contents of ArrayList
     * @param sortBy a string holding a number, "2" for sorting by project, otherwise it will sorty by date
     */
    public void listAllTasks(String sortBy) {
        Menu.separator('=',75);
        System.out.println(
                "Total Tasks = " + taskList.size() +
                        "\t\t (Completed = " + completedCount() + "\t\t" +
                        " Not Compeleted = " + notCompletedCount() +
                        " )"); Menu.separator('=',75);

        if (sortBy.equals("2")) {
            String displayFormat = "%-20s %-35s %-10s %-10s";

            if (taskList.size()>0) {
                System.out.println(String.format(displayFormat,"Project","Name","Deadline","Completed?"));
                System.out.println(String.format(displayFormat,"=======","=====","========","========="));
            } else {
                System.out.println("No tasks to show");
            }

            taskList.stream()
                    .sorted(Comparator.comparing(Task::getProject))
                    .forEach(task -> System.out.println(String.format(displayFormat,task.getProject(),
                            task.getName(),
                            task.getDeadline(),
                            (task.isDone()?"YES":"NO")
                    )));
        } else {
            String displayFormat = "%-10s %-35s %-20s %-10s";

            if (taskList.size() > 0) {
                System.out.println(String.format(displayFormat,"Deadline","Name","Project" , "COMPLETED"));
                System.out.println(String.format(displayFormat,"========","=====","=======" , "========="));
            } else {
                System.out.println("No tasks to show");
            }

            taskList.stream()
                    .sorted(Comparator.comparing(Task::getDeadline))
                    .forEach(task -> System.out.println(String.format(displayFormat,task.getDeadline(),
                            task.getName(),
                            task.getProject(),
                            (task.isDone() ? "YES" : "NO")
                    )));
        }
    }

}
