// 1. Define the Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// 2. Define the PassengerBogie class with Fail-Fast Validation
class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    // Getters
    public String getType() { return type; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return "PassengerBogie{Type='" + type + "', Capacity=" + capacity + "}";
    }
}

// 3. Main Application Class
class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return "Bogie{Type='" + type + "', Capacity=" + capacity + "}";
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. Create a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 80));

        // 2. Stream, 3. map() to extract capacity, 4. reduce() to sum
        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity) // Extract only the numbers
                .reduce(0, Integer::sum); // Start at 0, add every number found

        // 5. Display the result
        System.out.println("--- Train Capacity Analysis ---");
        System.out.println("Total Bogies: " + bogies.size());
        System.out.println("Total Seating Capacity: " + totalSeats);

        // Verification of Original List Integrity
        System.out.println("\nIntegrity Check: Original list still has " + bogies.size() + " bogies.");
public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management System: UC14 ===");

        // Scenario A: Valid Bogie Creation
        try {
            System.out.println("\n[Action] Creating a standard Sleeper bogie...");
            PassengerBogie s1 = new PassengerBogie("Sleeper", 72);
            System.out.println("✅ Success: " + s1);
        } catch (InvalidCapacityException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }

        // Scenario B: Zero Capacity Validation
        try {
            System.out.println("\n[Action] Creating an AC Chair bogie with 0 capacity...");
            PassengerBogie s2 = new PassengerBogie("AC Chair", 0);
            // This line will be skipped because an exception is thrown above
            System.out.println("✅ Success: " + s2);
        } catch (InvalidCapacityException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }

        // Scenario C: Negative Capacity Validation
        try {
            System.out.println("\n[Action] Creating a First Class bogie with -10 capacity...");
            PassengerBogie s3 = new PassengerBogie("First Class", -10);
            System.out.println("✅ Success: " + s3);
        } catch (InvalidCapacityException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }

        System.out.println("\n=== Program Execution Continued Safely ===");
import java.util.*
public class TrainConsistManagementApp {
    public static void main(String[] args) {
       
    }
}
