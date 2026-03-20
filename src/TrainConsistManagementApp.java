import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Step 1: Create LinkedHashSet to maintain order + uniqueness
        Set<String> trainFormation = new LinkedHashSet<>();

        // Step 2: Add bogies (in order)
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Step 3: Attempt to add duplicate
        trainFormation.add("Sleeper"); // Duplicate - will be ignored

        // Step 4: Display final formation
        System.out.println("🚆 Train Formation (Insertion Order Preserved):");
        for (String bogie : trainFormation) {
            System.out.print(bogie + " -> ");
        }
        System.out.println("END");
    }
}