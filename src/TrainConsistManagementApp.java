import java.util.ArrayList;
import java.util.List;

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
       
    }
}
