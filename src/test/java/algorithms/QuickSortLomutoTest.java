package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortLomutoTest {

    @Test
    void shouldSortCorrectly() {
        // given
        int[] input = {2, 1, 6, 3, 0, -3, 4, 5, 9, -322, 7};

        // when
        var result = QuickSortLomuto.sort(input);
        int[] expected = {-322, -3, 0, 1, 2, 3, 4, 5, 6, 7, 9};

        // then
        assertArrayEquals(expected, result);
    }

}