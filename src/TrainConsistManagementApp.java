import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Step 1: Create HashMap to store bogie-capacity mapping
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Step 2: Insert bogie capacities
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 78);
        bogieCapacityMap.put("First Class", 24);

        // Goods bogies (example capacities in tons)
        bogieCapacityMap.put("Rectangular Cargo", 100);
        bogieCapacityMap.put("Cylindrical Tanker", 80);

        // Step 3: Display bogie capacity details
        System.out.println("🚆 Bogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                    " | Capacity: " + entry.getValue());
        }

        // Step 4: Example lookup
        System.out.println("\n🔍 Capacity of Sleeper: " +
                bogieCapacityMap.get("Sleeper"));
    }
}