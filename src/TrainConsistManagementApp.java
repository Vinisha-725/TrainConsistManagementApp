import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Assuming the Bogie class from previous Use Cases
class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bogie{Type='" + type + "', Capacity=" + capacity + "}";
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. Reuse/Create the Bogie list (UC7 Context)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair Car", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 80));
        bogies.add(new Bogie("Sleeper", 72));

        System.out.println("--- Original Consist ---");
        bogies.forEach(System.out::println);

        // 2. Convert to Stream, 3. Filter, 4. Collect
        // Condition: Capacity > 60
        List<Bogie> highCapacityBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        // Note: In Java 16+, you can use .toList() directly

        // 5. Display Filtered Bogies
        System.out.println("\n--- High-Capacity Bogies (Capacity > 60) ---");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            highCapacityBogies.forEach(System.out::println);
        }

        // Integrity Check: Original list remains unchanged
        System.out.println("\nOriginal list size: " + bogies.size());
    }
}