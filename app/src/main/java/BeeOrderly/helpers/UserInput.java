package main.java.BeeOrderly.helpers;


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
