package main;

import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Array of bogie type names
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogieTypes));

        // Sort alphabetically using built-in Arrays.sort()
        Arrays.sort(bogieTypes);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(bogieTypes));
    }
}