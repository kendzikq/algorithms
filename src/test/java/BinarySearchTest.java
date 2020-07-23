import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @ParameterizedTest
    @CsvSource(value = {
            "2,     0",
            "3,     1",
            "5,     2",
            "8,     3",
            "9,     4"
    })
    void testSomething(int searchedValue, int expectedPosition) {
        // given
        int input[] = {2, 3, 5, 8, 9};

        // when-then
        var iterativeResult = BinarySearch.iterativeSearch(input, searchedValue);
        var recursiveSearch = BinarySearch.recursiveSearch(input, searchedValue);

        assertEquals(expectedPosition, iterativeResult);
        assertEquals(expectedPosition, recursiveSearch);
    }
}