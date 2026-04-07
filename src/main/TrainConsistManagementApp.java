import java.util.Arrays;

public class TrainConsistManagementApp {

    // Bubble Sort Method
    public static void bubbleSort(int[] capacities) {

        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false; // optimization

            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {

                    // Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps → already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        // Passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(capacities));

        // Apply Bubble Sort
        bubbleSort(capacities);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(capacities));
    }
}