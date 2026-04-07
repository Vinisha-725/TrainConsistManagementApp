import java.util.*;

// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Goods Bogie Class
class GoodsBogie {
    String shape;   // Rectangular / Cylindrical
    String cargo;   // Petroleum, Coal, etc.

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "GoodsBogie{Shape='" + shape + "', Cargo='" + cargo + "'}";
    }
}

// Main Application
public class TrainConsistManagementApp {

    // Cargo assignment logic with try-catch-finally
    public static void assignCargo(GoodsBogie bogie, String cargoType) {
        try {
            // Validation
            if (bogie.getShape().equalsIgnoreCase("Rectangular") &&
                    cargoType.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe Cargo! Petroleum cannot be assigned to Rectangular bogie.");
            }

            // Safe assignment
            bogie.setCargo(cargoType);
            System.out.println("Cargo assigned successfully: " + cargoType);

        } catch (CargoSafetyException e) {
            // Handle exception
            System.out.println("ERROR: " + e.getMessage());

        } finally {
            // Always executes
            System.out.println("Cargo assignment attempt completed.\n");
        }
    }

    public static void main(String[] args) {

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // Safe assignment
        assignCargo(b1, "Petroleum");

        // Unsafe assignment
        assignCargo(b2, "Petroleum");

        // Program continues
        assignCargo(b2, "Coal");

        System.out.println("Final Bogie States:");
        System.out.println(b1);
        System.out.println(b2);
    }
}