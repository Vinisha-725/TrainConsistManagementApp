import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() { return type; }

    @Override
    public String toString() {
        return "Bogie{Type='" + type + "', Capacity=" + capacity + "}";
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. Create a list of bogies (Reuse logic from UC7/UC8)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 56));

        // 2. Convert to stream, 3. Apply groupingBy, 4. Store in Map
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        // 5. Display Grouped Result
        System.out.println("--- Grouped Train Consist Report ---");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Category: [" + type + "] - Count: " + list.size());
            list.forEach(b -> System.out.println("  -> " + b));
        });

        // Verification of Original List Integrity
        System.out.println("\nOriginal list size remains: " + bogies.size());
    }
}