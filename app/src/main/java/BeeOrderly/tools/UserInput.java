package main.java.BeeOrderly.tools;


import main.java.BeeOrderly.model.Task;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInput {
    private static Scanner scan;


    public UserInput(){
        scan = new Scanner(System.in);
    }

    public static String nextLine(){
        return scan.nextLine();
    }

    public Task createTask() {
        System.out.println("Please enter the following details to add a task:");
        System.out.print("> Task name  : ");
        String name = UserInput.nextLine();
        System.out.print("> Project name: ");
        String project = UserInput.nextLine();
        System.out.print("> Deadline [format: yyyy-mm-dd] : ");
        LocalDate deadline = LocalDate.parse(UserInput.nextLine());

        return new Task(name, project,deadline);
    }
}
