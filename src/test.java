import java.util.Arrays;
import java.util.Scanner;

class TrainConsistManagementApp {

    // Binary Search with defensive check
    public static boolean searchBogieWithValidation(String[] bogieIDs, String searchKey) {
        // Defensive programming: check if bogie array is empty
        if (bogieIDs == null || bogieIDs.length == 0) {
            throw new IllegalStateException("Cannot search: No bogies are available in the train.");
        }

        // Optional: sort the array for binary search
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
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Bogie ID not found.");
        return false;
    }

    public static void main(String[] args) {
        // Example bogie arrays
        String[] bogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        String[] emptyBogies = {};

        Scanner sc = new Scanner(System.in);

        // Attempt search on non-empty array
        System.out.println("Searching in a non-empty bogie array:");
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = sc.nextLine().trim();

        try {
            boolean found = searchBogieWithValidation(bogies, searchKey);
            System.out.println("Search Result: " + (found ? "Bogie exists." : "Bogie does NOT exist."));
        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Attempt search on empty array
        System.out.println("\nSearching in an empty bogie array:");
        try {
            searchBogieWithValidation(emptyBogies, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        sc.close();
    }
}