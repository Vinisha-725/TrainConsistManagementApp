package main;

import java.util.Scanner;

public class TrainConsistManagementApp {

    // Linear search method
    public static boolean linearSearchBogie(String[] bogieIDs, String searchKey) {
        for (int i = 0; i < bogieIDs.length; i++) {
            if (bogieIDs[i].equals(searchKey)) {
                System.out.println("Bogie ID found at index: " + i);
                return true; // early termination on match
            }
        }
        System.out.println("Bogie ID not found.");
        return false;
    }

    public static void main(String[] args) {
        // Array of bogie IDs (unsorted)
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        Scanner sc = new Scanner(System.in);
        System.out.println("Bogie IDs in the consist:");
        for (String id : bogieIDs) {
            System.out.print(id + " ");
        }
        System.out.println("\n");

        // Accept search key from user
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = sc.nextLine().trim();

        // Perform linear search
        boolean found = linearSearchBogie(bogieIDs, searchKey);

        if (found) {
            System.out.println("Search Result: Bogie exists in the consist.");
        } else {
            System.out.println("Search Result: Bogie does NOT exist in the consist.");
        }

        sc.close();
    }
}