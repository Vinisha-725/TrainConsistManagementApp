import java.util.LinkedList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Step 1: Create LinkedList to maintain order
        LinkedList<String> trainConsist = new LinkedList<>();

        // Step 2: Add bogies (initial formation)
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("🚆 Initial Train Consist:");
        System.out.println(trainConsist);

        // Step 3: Insert Pantry Car at position 2 (index 1)
        trainConsist.add(1, "Pantry");

        System.out.println("\n➕ After Adding Pantry Car at Position 2:");
        System.out.println(trainConsist);

        // Step 4: Remove first and last bogie
        trainConsist.removeFirst(); // removes Engine
        trainConsist.removeLast();  // removes Guard

        System.out.println("\n➖ After Removing First and Last Bogie:");
        System.out.println(trainConsist);

        // Step 5: Display final train consist
        System.out.println("\n🚆 Final Ordered Train Consist:");
        for (String bogie : trainConsist) {
            System.out.print(bogie + " -> ");
        }
        System.out.println("END");
    }
}