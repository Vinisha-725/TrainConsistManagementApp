import java.util.ArrayList;
import java.util.List;

class GoodsBogie {
    String type;
    String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() { return type; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return "GoodsBogie{Type='" + type + "', Cargo='" + cargo + "'}";
    }
}

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
        // 1. Prepare a list of goods bogies
        List<GoodsBogie> goodsConsist = new ArrayList<>();
        goodsConsist.add(new GoodsBogie("Rectangular", "Coal"));
        goodsConsist.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsConsist.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsConsist.add(new GoodsBogie("Box", "Grain"));

        // 2. Stream, 3. allMatch() with 4. Conditional Logic
        // Rule: If type is "Cylindrical", cargo MUST be "Petroleum"
        boolean isTrainSafe = goodsConsist.stream().allMatch(bogie -> {
            if (bogie.getType().equalsIgnoreCase("Cylindrical")) {
                return bogie.getCargo().equalsIgnoreCase("Petroleum");
            }
            return true; // Non-cylindrical bogies pass this specific rule
        });

        // 5. Display Result
        System.out.println("--- Safety Compliance Report ---");
        goodsConsist.forEach(System.out::println);

        if (isTrainSafe) {
            System.out.println("\n✅ STATUS: Train is Safety Compliant. Ready for departure.");
        } else {
            System.out.println("\n❌ STATUS: SAFETY VIOLATION DETECTED! Check Cylindrical bogie cargo.");
        }
import java.util.*
public class TrainConsistManagementApp {
    public static void main(String[] args) {
       
    }
}
