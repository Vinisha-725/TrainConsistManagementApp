import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    // Regex Constants
    // TRN- followed by exactly 4 digits
    private static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";
    // PET- followed by exactly 2 uppercase letters
    private static final String CARGO_CODE_REGEX = "^PET-[A-Z]{2}$";

    public static void main(String[] args) {
        // Test cases for Train ID
        validateTrainID("TRN-1234"); // Valid
        validateTrainID("TRAIN12");  // Invalid (Wrong prefix)
        validateTrainID("TRN-123");   // Invalid (Too short)

        // Test cases for Cargo Code
        validateCargoCode("PET-AB"); // Valid
        validateCargoCode("PET-ab"); // Invalid (Lowercase)
        validateCargoCode("PET-12"); // Invalid (Digits instead of letters)
    }

    public static boolean validateTrainID(String trainID) {
        Pattern pattern = Pattern.compile(TRAIN_ID_REGEX);
        Matcher matcher = pattern.matcher(trainID);

        if (matcher.matches()) {
            System.out.println("✔ Valid Train ID: " + trainID);
            return true;
        } else {
            System.out.println("❌ Invalid Train ID: " + trainID);
            return false;
        }
    }

    public static boolean validateCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile(CARGO_CODE_REGEX);
        Matcher matcher = pattern.matcher(cargoCode);

        if (matcher.matches()) {
            System.out.println("✔ Valid Cargo Code: " + cargoCode);
            return true;
        } else {
            System.out.println("❌ Invalid Cargo Code: " + cargoCode);
            return false;
        }
import java.util.*
public class TrainConsistManagementApp {
    public static void main(String[] args) {
       
    }
}
