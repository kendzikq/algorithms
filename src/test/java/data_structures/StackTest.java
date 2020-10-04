package data_structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTest {

    @Test
    void shouldWorkAsLIFO() {
        // given
        var stack = new Stack();
        stack.push(3);
        stack.push(5);
        stack.push(0);
        stack.push(9);

        // when
        var value = stack.pop();
        var value2 = stack.pop();

        // then
        assertEquals(9, value);
        assertEquals(0, value2);

        // when
        stack.push(7);
        var value3 = stack.pop();
        var value4 = stack.pop();

        // then
        assertEquals(7, value3);
        assertEquals(5, value4);
    }

    @Test
    void shouldRaiseStackOverFlowException() {
        // given
        var stack = new Stack(2);

        // when - then
        stack.push(0);
        stack.push(1);
        assertThrows(RuntimeException.class,
                () -> stack.push(15),
                "stackOverFlow capacity = 2");
    }

    @Test
    void shouldRaiseStackIsEmptyException() {
        // given
        var stack = new Stack(2);

        // when - then
        stack.push(0);
        stack.pop();
        assertThrows(RuntimeException.class,
                stack::pop,
                "stack is empty");
    }
}