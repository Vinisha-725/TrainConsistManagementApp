import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    int capacity;
    public Bogie(int capacity) { this.capacity = capacity; }
    public int getCapacity() { return capacity; }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. Prepare a large collection of bogies for meaningful measurement
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie((int) (Math.random() * 100)));
        }

        // --- LOOP BASED FILTERING ---
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;

        // --- STREAM BASED FILTERING ---
        long startStream = System.nanoTime();
        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        // 5 & 6. Display Results
        System.out.println("--- Performance Comparison (100,000 Bogies) ---");
        System.out.println("Loop Duration   : " + loopDuration + " ns");
        System.out.println("Stream Duration : " + streamDuration + " ns");

        // Validation: Ensure results are identical
        if (loopResult.size() == streamResult.size()) {
            System.out.println("\n✅ Logic Check: Both methods returned " + loopResult.size() + " bogies.");
        }
    }
}