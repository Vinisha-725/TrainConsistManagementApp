import main.TrainConsistManagementApp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class test {

    @Test
    void testBinarySearch_BogieFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(bogies, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(TrainConsistManagementApp.binarySearchBogie(bogies, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(bogies, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogies = {"BG101"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(bogies, "BG101"));
        assertFalse(TrainConsistManagementApp.binarySearchBogie(bogies, "BG999"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogies = {};
        assertFalse(TrainConsistManagementApp.binarySearchBogie(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] bogies = {"BG309","BG101","BG550","BG205","BG412"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(bogies, "BG205"));
    }
}