import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Bogie Class
class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Bogie{Type='" + type + "', Capacity=" + capacity + "}";
    }
}

// Main Application
public class TrainConsistManagementApp {

    // ✅ Method for filtering (important for test cases)
    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold) // Stream + Lambda
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        // Create bogie list (UC7 reused)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair Car", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 80));
        bogies.add(new Bogie("Sleeper", 72));

        System.out.println("--- Original Consist ---");
        bogies.forEach(System.out::println);

        // Apply Stream Filtering
        List<Bogie> filteredBogies = filterHighCapacityBogies(bogies, 60);

        System.out.println("\n--- High Capacity Bogies (Capacity > 60) ---");
        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            filteredBogies.forEach(System.out::println);
        }

        // Check original list integrity
        System.out.println("\nOriginal list size: " + bogies.size());
    }
}