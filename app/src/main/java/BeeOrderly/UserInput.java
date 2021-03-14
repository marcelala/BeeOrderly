package main.java.BeeOrderly;


import java.util.Scanner;

public class UserInput {
    private static Scanner scan;


    public UserInput(){
        scan = new Scanner(System.in);
    }

    public static String nextLine(){
        return scan.nextLine();
    }


}
