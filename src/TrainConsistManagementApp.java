import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Step 1: Create HashSet to store unique bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Step 2: Add bogie IDs (including duplicates intentionally)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // Duplicate
        bogieIds.add("BG104");
        bogieIds.add("BG102"); // Duplicate

        // Step 3: Display all bogie IDs
        System.out.println("🚆 Unique Bogie IDs in Train Consist:");
        for (String id : bogieIds) {
            System.out.println(id);
        }
    }
}