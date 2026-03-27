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
    }
}