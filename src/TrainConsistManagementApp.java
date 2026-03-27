import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    }
}