import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] emptyBogies = {};
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            TrainConsistManagementApp.searchBogieWithValidation(emptyBogies, "BG101");
        });
        assertEquals("Cannot search: No bogies are available in the train.", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogies = {"BG101","BG205"};
        assertDoesNotThrow(() -> {
            TrainConsistManagementApp.searchBogieWithValidation(bogies, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogies = {"BG101","BG205","BG309"};
        assertTrue(TrainConsistManagementApp.searchBogieWithValidation(bogies, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogies = {"BG101","BG205","BG309"};
        assertFalse(TrainConsistManagementApp.searchBogieWithValidation(bogies, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogies = {"BG101"};
        assertTrue(TrainConsistManagementApp.searchBogieWithValidation(bogies, "BG101"));
        assertFalse(TrainConsistManagementApp.searchBogieWithValidation(bogies, "BG999"));
    }
}