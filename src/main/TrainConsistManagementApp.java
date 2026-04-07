package main;

import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {

    // Binary Search method (returns true if bogie exists)
    public static boolean binarySearchBogie(String[] bogieIDs, String searchKey) {
        if (bogieIDs == null || bogieIDs.length == 0) {
            System.out.println("Bogie list is empty.");
            return false;
        }

        // Ensure array is sorted before searching
        Arrays.sort(bogieIDs);

        int low = 0;
        int high = bogieIDs.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = bogieIDs[mid].compareTo(searchKey);

            if (cmp == 0) {
                System.out.println("Bogie ID found at index: " + mid);
                return true;
            } else if (cmp < 0) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }

        System.out.println("Bogie ID not found.");
        return false;
    }

    public static void main(String[] args) {
        // Example bogie IDs (unsorted input)
        String[] bogieIDs = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        System.out.println("Original Bogie IDs:");
        System.out.println(Arrays.toString(bogieIDs));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = sc.nextLine().trim();

        boolean found = binarySearchBogie(bogieIDs, searchKey);

        if (found) {
            System.out.println("Search Result: Bogie exists in the consist.");
        } else {
            System.out.println("Search Result: Bogie does NOT exist in the consist.");
        }

        sc.close();
    }
}