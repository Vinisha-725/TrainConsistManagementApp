package test;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class testcase {

    // Helper method
    private List<Bogie> createBogies() {
        return new ArrayList<>(List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair Car", 56),
                new Bogie("First Class", 24),
                new Bogie("General", 80),
                new Bogie("Sleeper", 72)
        ));
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result =
                TrainConsistManagementApp.filterHighCapacityBogies(createBogies(), 70);

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 70));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("General", 80)
        );

        List<Bogie> result =
                TrainConsistManagementApp.filterHighCapacityBogies(bogies, 70);

        assertTrue(result.stream().noneMatch(b -> b.getCapacity() == 70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = List.of(
                new Bogie("First Class", 40),
                new Bogie("AC Chair Car", 50)
        );

        List<Bogie> result =
                TrainConsistManagementApp.filterHighCapacityBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 75),
                new Bogie("General", 85),
                new Bogie("Sleeper", 90)
        );

        List<Bogie> result =
                TrainConsistManagementApp.filterHighCapacityBogies(bogies, 70);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = List.of(
                new Bogie("First Class", 20),
                new Bogie("AC Chair Car", 50)
        );

        List<Bogie> result =
                TrainConsistManagementApp.filterHighCapacityBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 80),
                new Bogie("General", 90)
        );

        List<Bogie> result =
                TrainConsistManagementApp.filterHighCapacityBogies(bogies, 70);

        assertEquals(bogies.size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result =
                TrainConsistManagementApp.filterHighCapacityBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = createBogies();
        List<Bogie> copy = new ArrayList<>(bogies);

        TrainConsistManagementApp.filterHighCapacityBogies(bogies, 70);

        assertEquals(copy.size(), bogies.size());

        for (int i = 0; i < bogies.size(); i++) {
            assertEquals(copy.get(i).getCapacity(), bogies.get(i).getCapacity());
            assertEquals(copy.get(i).getType(), bogies.get(i).getType());
        }
    }
}